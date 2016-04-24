package com.example;


public class Train
{
    private String nazwa;
    private int numer;
    private boolean opoznienie = false;
	
	public Train(String nazwa, int numer)
	{
		this.nazwa = nazwa;
		this.numer = numer;
		this.opoznienie = false;
	}

    public String getNazwa()
	{
		return nazwa;
    }
}
