package com.mbeiger;


public interface MessageService {
    ConnectionStatus checkConnection(String server);

    SendingStatus send(String server, String contents) throws MalformedRecipientException;
}
