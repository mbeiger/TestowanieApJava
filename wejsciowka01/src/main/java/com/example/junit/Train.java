package com.example.junit;

public class Train {

	private String nazwa;

	private boolean dostepny;

	private int numer;

	public Train(){
	}

	public Train(String nazwa, boolean dostepny, int numer){
		this.nazwa = nazwa;
		this.dostepny = dostepny;
		this.numer = numer;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public boolean getDostepny() {
		return dostepny;
	}

	public void setDostepny(boolean dostepny) {
		this.dostepny = dostepny;
	}

	public int getNumer() {
		return numer;
	}

	public void setNumer(int numer) {
		this.numer = numer;
	}



}
