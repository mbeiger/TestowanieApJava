package com.lab01.app;

public class Calculator {

	public Calculator()
	{
		System.out.println("Calculator: " + this);
	}
	public double add(double a, double b)
	{
		return a+b;
	}
	public double sub(double a, double b)
	{
		return a-b;
	}
	public double multi(double a, double b)
	{
		return a*b;
	}
	public double div(double a, double b)
	{
		return a/b;
	}
	public boolean greater(double a, double b)
	{
		return (a>b) ? true:false;
	}
}
