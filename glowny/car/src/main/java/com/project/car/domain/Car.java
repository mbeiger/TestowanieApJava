package com.project.car.domain;

public class Car {
	private long id;
	
	private String model;
	private int rok;
	
	public Car() {
	}
	public Car(String model, int rok) {
		super();
		this.model = model;
		this.rok = rok;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRok() {
		return rok;
	}
	public void setRok(int rok) {
		this.rok = rok;
	}
}
