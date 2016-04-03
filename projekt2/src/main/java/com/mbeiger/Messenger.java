package com.mbeiger;

public class Messenger {
    private MessageService messageService;

    public Messenger(MessageService messageService) {
        this.messageService = messageService;
    }

    public Messenger() {

    }

    public int SendCommunique(String communique, String address) {

        try {
            if (TestConnectionWithServer(address) != 0 || messageService.send(address, communique) != SendingStatus.SENT)
                return 1;
        } catch (MalformedRecipientException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int TestConnectionWithServer(String address) {

        if (messageService.checkConnection(address) != ConnectionStatus.SUCCESS)
            return 1;

        return 0;
    }

}
