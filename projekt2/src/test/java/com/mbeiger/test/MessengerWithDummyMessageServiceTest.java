package com.mbeiger.test;
import com.mbeiger.DummyMessageService;
import com.mbeiger.Messenger;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;


public class MessengerWithDummyMessageServiceTest {

    private Messenger messenger;

    @Before
    public void Init() {
        messenger = new Messenger(new DummyMessageService());
    }

    @Test
    public void TestConnectionWithServerForValidAdress() {
        assertThat(messenger.TestConnectionWithServer("www.inf.ug.edu.pl"), is(0));
    }

    @Test
    public void TestConnectionWithServerForInvalidAdress() {
        assertThat(messenger.TestConnectionWithServer("www.inf.ug.edu.eu"), is(1));
    }

    @Test
    public void SendCommuniqueForValidMessageValidServer() {
        assertThat(messenger.SendCommunique("Breaking news", "www.ms.pl"), is(anyOf(equalTo(1), equalTo(0))));
    }

    @Test
    public void SendCommuniqueForInvalidMessageValidServer() {
        assertThat(messenger.SendCommunique("Dd", "www.ms.pl"), is(1));
    }

    @Test
    public void SendCommuniqueForValidMessageInvalidServer() {
        assertThat(messenger.SendCommunique("Breaking news", "www.ms.eu"), is(1));
    }

    @Test
    public void SendCommuniqueForInvalidMessageInvalidServer() {
        assertThat(messenger.SendCommunique("dd", "www.ms.eu"), is(1));
    }
}
