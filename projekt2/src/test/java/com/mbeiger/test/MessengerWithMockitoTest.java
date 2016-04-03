package com.mbeiger.test;
import com.mbeiger.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MessengerWithMockitoTest {

    private Messenger messenger;
    private MessageService messageService;

    @Before
    public void setUp() {
        messageService = mock(MessageService.class);
        messenger = new Messenger(messageService);
    }

    @Test
    public void TestConnectionWithServerForValidAddress() {
        when(messageService.checkConnection("www.inf.ug.edu.pl")).thenReturn(ConnectionStatus.SUCCESS);
        assertThat(messenger.TestConnectionWithServer("www.inf.ug.edu.pl"), is(0));
    }

    @Test
    public void TestConnectionWithServerForInvalidAddress() {
        when(messageService.checkConnection("www.inf.ug.edu.eu")).thenReturn(ConnectionStatus.FAILURE);
        assertThat(messenger.TestConnectionWithServer("www.inf.ug.edu.eu"), is(1));
    }

    @Test
    public void SendCommuniqueForValidMessageValidServer() throws MalformedRecipientException {
        when(messageService.checkConnection("www.ms.pl")).thenReturn(ConnectionStatus.SUCCESS);
        when(messageService.send("www.ms.pl", "Breaking news")).thenReturn(SendingStatus.SENT);
        assertThat(messenger.SendCommunique("Breaking news", "www.ms.pl"), is(equalTo(0)));
    }

    @Test
    public void SendCommuniqueForInvalidMessageValidServer() throws MalformedRecipientException {
        when(messageService.checkConnection("www.ms.pl")).thenReturn(ConnectionStatus.SUCCESS);
        when(messageService.send("www.ms.pl", "Dd")).thenThrow(new MalformedRecipientException());
        assertThat(messenger.SendCommunique("Dd", "www.ms.pl"), is(1));
    }

    @Test
    public void SendCommuniqueForValidMessageInvalidServer() throws MalformedRecipientException {
        when(messageService.checkConnection("www.ms.eu")).thenReturn(ConnectionStatus.FAILURE);
        assertThat(messenger.SendCommunique("Breaking news", "www.ms.eu"), is(1));
    }

    @Test
    public void SendCommuniqueForInvalidMessageInvalidServer() throws MalformedRecipientException {
        when(messageService.checkConnection("www.ms.eu")).thenReturn(ConnectionStatus.FAILURE);
        assertThat(messenger.SendCommunique("dd", "www.ms.eu"), is(1));
    }


}
