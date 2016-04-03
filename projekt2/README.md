Jesteś deweloperem piszącym fragment (bardzo uproszczonej) aplikacji (tutaj klasy Messenger) wysyłającej komunikaty do serwera. Twoja klasa korzysta z implementacji interfejsu MessageService. Zadaniem Twojej aplikacji (uwaga: często spotykane w praktyce) jest m.in. ukrywanie statusów oraz wyjątków generowanych przez wykorzystywane komponenty takie jak MessageService. Zgodnie z życzeniem Klienta Twoja metoda odpowiedzialna za wysyłanie komunikatów ma zwracać (zamiast statusów i ew. wyjątków) liczby 0 (powodzenie), 1 (problemy z wysłaniem), 2(niewłaściwie zbudowany adres serwera lub komunikat). Klasa Messenger powinna też dostarczać metodę do testowania połączenia z serwerem zwracającą liczbę 0 w przypadku sukcesu a 1 w przypadku błędu przy połączeniu. 

Przykładowy system wraz z podstawowymi (przykładowymi) testami jest zaimplementowany, należy go uzupełnić w miarę potrzeb. Głównym zadaniem jest testowanie jednostkowe Twojej aplikacji w izolacji tj. BEZ GOTOWEJ IMPLEMENTACJI MessageService.

Przy użyciu poznawanych technologii należy przeprowadzić testy jednostkowe w izolacji:
 - bez użycia dodatkowych technologii 
 - przy użyciu  dynamic proxy 
 - przy pomocy frameworka mockito
 - przy pomocy frameworka easymock 
 
Kontrakt na interfejs MessageService:

public interface MessageService {
    /* Metoda używana do testowania połączeń do danego serwera. Zwraca statusy:
	  ConnectionStatus.SUCCES w przypadku powodzenia
	  ConnectionStatus.FAILURE w przypadku błędu. 
	  Wymagamy aby adres serwera był poprawnym adresem w uproszczonym formacie URL, np:
	  wp.pl, inf.ug.edu.pl 
	  Uwaga: połączenie kończy się sukcesem tylko dla adresów z poddomeny .pl	
	*/
	ConnectionStatus checkConnection(String server);
	
	 /* Metoda używana do wysyłania komunikatów do serwera. 
	  Wymagamy aby adres serwera był przynajmniej 4 znakowy a komunikat przynajmniej 3 znakowy, w przeciwnym wypadku metoda wyrzuca MalformedRecipientException.
	 Zwraca statusy:
	  SendingStatus.SENT w przypadku powodzenia operacji
	  SendingStatus.SENDING_ERROR w przypadku błędu (przerwane połączenie itp. niezależne błędy) 
 	
	*/
	SendingStatus send(String server, String contents) throws MalformedRecipientException;

}
 
