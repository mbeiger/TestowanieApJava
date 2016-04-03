package com.lab01.app;

public class LiczbaRzymska {
private int liczba;
	
	LiczbaRzymska(int a){
		liczba = a;
	}

	@Override
	public String toString() {
		String ciag = "";
		if(liczba>0 && liczba<=10){
			while (liczba >= 10) {
				ciag += "X";
				liczba -= 10;
			}
			while (liczba >= 9) {
				ciag += "IX";
				liczba -= 9;
			}
			while (liczba >= 5) {
				ciag += "V";
				liczba -= 5;
			}
			while (liczba >= 4) {
				ciag += "IV";
				liczba -= 4;
			}
			while (liczba >= 1) {
				ciag += "I";
				liczba -= 1;
			}
		} else{
			ciag = "Zla liczba!";
		}
		return ciag;
	}
}
