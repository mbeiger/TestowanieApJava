package com.lab01.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	private Calculator calc = new Calculator();
	
	@Test
	public void addCheck()
	{
		System.out.println("Add: " + this);
		assertEquals(5,calc.add(3,2));
	}
	@Test
	public void addSub()
	{
		System.out.println("Sub: " + this);
		assertEquals(1,calc.sub(3,2));
	}
	@Test
	public void addMulti()
	{
		System.out.println("Multi: " + this);
		assertEquals(6,calc.multi(3,2));
	}
	@Test
	public void addDiv()
	{
		System.out.println("Div: " + this);
		assertEquals(5,calc.div(50,10));
	}
	@Test
	public void addGreat()
	{
		System.out.println("Greater: " + this);
		assertEquals(true,calc.greater(50,10));
	}
	@Test (expected = ArithmeticException.class)
	public void addDivZero()
	{
		System.out.println("DivZero: " + this);
		assertEquals(6,calc.div(3,0));
	}	
}
