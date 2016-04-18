package com.example.junit;

public class Train {
	String typ;
	String nazwa;
	int nr;
	
	public Train(){
		
	}
	
	public Train(String typ, String nazwa, int nr){
		this.typ = typ;
		this.nazwa = nazwa;
		this.nr = nr;
	}
	
	public String getnazwa(){
		return this.nazwa;
	}
	
	public void setnazwa(String nazwa){
		this.nazwa = nazwa;
	}
	
	public int getnr(){
		return this.nr;
	}
	
	public void setnr(int nr){
		this.nr = nr;
	}
	
	public String gettyp(){
		return this.typ;
	}
	
	public void settyp(String typ){
		this.typ = typ;
	}
	
}
