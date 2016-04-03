package com.mbeiger.test;
import com.mbeiger.*;
import org.easymock.EasyMockRule;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MessengerWithEasyMockTest extends EasyMockSupport {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private MessageService messageService;

    @TestSubject
    private Messenger messenger = new Messenger();

    @After
    public void verifyMock() {
        verifyAll();
    }

    @Test
    public void TestConnectionWithServerForValidAdress() {
        expect(messageService.checkConnection("www.inf.ug.edu.pl")).andReturn(ConnectionStatus.SUCCESS);
        replay(messageService);
        assertThat(messenger.TestConnectionWithServer("www.inf.ug.edu.pl"), is(0));
    }

    @Test
    public void TestConnectionWithServerForInvalidAdress() {
        expect(messageService.checkConnection("www.inf.ug.edu.eu")).andReturn(ConnectionStatus.FAILURE);
        replay(messageService);
        assertThat(messenger.TestConnectionWithServer("www.inf.ug.edu.eu"), is(1));
    }

    @Test
    public void SendCommuniqueForValidMessageValidServer() throws MalformedRecipientException {
        expect(messageService.checkConnection("www.ms.pl")).andReturn(ConnectionStatus.SUCCESS);
        expect(messageService.send("www.ms.pl", "Breaking news")).andReturn(SendingStatus.SENT);
        replay(messageService);
        assertThat(messenger.SendCommunique("Breaking news", "www.ms.pl"), is(equalTo(0)));
    }

    @Test
    public void SendCommuniqueForInvalidMessageValidServer() throws MalformedRecipientException {
        expect(messageService.checkConnection("www.ms.pl")).andReturn(ConnectionStatus.SUCCESS);
        expect(messageService.send("www.ms.pl", "Dd")).andThrow(new MalformedRecipientException());
        replay(messageService);
        assertThat(messenger.SendCommunique("Dd", "www.ms.pl"), is(1));
    }

    @Test
    public void SendCommuniqueForValidMessageInvalidServer() throws MalformedRecipientException {
        expect(messageService.checkConnection("www.ms.eu")).andReturn(ConnectionStatus.FAILURE);
        replay(messageService);
        assertThat(messenger.SendCommunique("Breaking news", "www.ms.eu"), is(1));
    }

    @Test
    public void SendCommuniqueForInvalidMessageInvalidServer() throws MalformedRecipientException {
        expect(messageService.checkConnection("www.ms.eu")).andReturn(ConnectionStatus.FAILURE);
        replay(messageService);
        assertThat(messenger.SendCommunique("dd", "www.ms.eu"), is(1));
    }
}
