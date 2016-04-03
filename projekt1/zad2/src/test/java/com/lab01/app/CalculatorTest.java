package com.lab01.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	private Calculator calc = new Calculator();
	
	@Test
	public void addCheck()
	{
		System.out.println("Add: " + this);
		assertEquals(5.135,calc.add(3.123,2.012), 0.001);
	}
	@Test
	public void addSub()
	{
		System.out.println("Sub: " + this);
		assertEquals(1.111,calc.sub(3.123,2.012), 0.001);
	}
	@Test
	public void addMulti()
	{
		System.out.println("Multi: " + this);
		assertEquals(6.06165129,calc.multi(3.0123,2.0123), 0.001);
	}
	@Test
	public void addDiv()
	{
		System.out.println("Div: " + this);
		assertEquals(40.681523501,calc.div(50.201,1.234), 0.001);
	}
	@Test
	public void addGreat()
	{
		System.out.println("Greater: " + this);
		assertEquals(false,calc.greater(50.123,100.123));
	}
	@Test (expected = AssertionError.class)
	public void addDivZero()
	{
		System.out.println("DivZero: " + this);
		assertEquals(3.0123, calc.div(3.0123,0.00), 0.001);
	}	
}
