# Projekt 1 (LAB 1)
Przed przystąpieniem do rozwiązywania zadań:
1) załóż repozytorium na github.com lub bitbucket.org . W tym repozytorium przechowuj wszystkie projekty rozwiązywane na laboratoriach. Kolejne rozwiązania przechowuj w odpowiednich katalogach np. lab01/zad1/, lab01/zad2 ... lab15/zad9/
2) zaproś mnie do utworzonego przez siebie repozytorium. Mój login to KubaNeumann (github) JakubNeumann (bitbucket)

Zad. 1a. Napisz klasę Calculator, która będzie dostarczała pięć publicznych metod
int add(int a, int b)
int sub(int a, int b)
int multi(int a, in b)
int div(int a, int b)  (dzielenie całkowitoliczbowe)
boolean greater(int a, int b)

Napisz klasę CalculatorTest, która będzie klasą testującą dla klasy Calculator.
Zaplanuj i zaimplementuj odpowiednie przypadki testowe (sprawdzające poprawność
wykonywanych operacji). Skorzystaj z różnych asercji.

Zad. 1b. Rozszerz klasę CalculatorTest o przypadek testowy, który zakończy się
błędem, gdy przy próbie dzielenia przez 0 nie wystąpi wyjątek typu ArithmeticException.

Zad. 2. Napisz klasę Calculator, która będzie działała analogicznie do tej z zadania 1, ale będzie wykonywała operacje na liczbach typu double. Napisz klasę 
CalculatorTest (zwróć uwagę na możliwe błędy w zaokrągleniach, jak sobie z tym poradzić?).

Zad. 3. Napisz klasę LiczbaRzymska, która będzie posiadała jedno prywatne pole zawierające liczbę (zainicjalizowane w konstruktorze) i metodę toString(), która
będzie zwracała tę samą liczbę zapisaną w rzymskim systemie zapisywania liczb.

Przed implementacją metody toString() zastanów się jak powinna zachować się ta klasa w różnych przypadkach np. gdy w konstruktorze podano liczbę ujemną. Zaimplementuj klasę testującą i odpowiednie przypadki testowe. W tym momencie testy oczywiście zakończą się niepowodzeniem. Zaimplementuj metodę toString() i uruchom ponownie testy.


Asercje
https://github.com/junit-team/junit/wiki/Assertions

Testowanie wyjątków
https://github.com/junit-team/junit/wiki/Exception-testing
 
Agregowanie testów (JUnit Suites)
https://github.com/junit-team/junit/wiki/Aggregating-tests-in-suites 

Matchers
https://github.com/junit-team/junit/wiki/Matchers-and-assertthat

Testy z parametrami
https://github.com/junit-team/junit/wiki/Parameterized-tests

Testowanie czasu wykonania
https://github.com/junit-team/junit/wiki/Timeout-for-tests 
