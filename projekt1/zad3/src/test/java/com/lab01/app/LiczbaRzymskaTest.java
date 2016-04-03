package com.lab01.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class LiczbaRzymskaTest {

	private LiczbaRzymska ciag = new LiczbaRzymska(9);
	private LiczbaRzymska ciag2 = new LiczbaRzymska(6);
	private LiczbaRzymska ciagTooBig = new LiczbaRzymska(20);
	private LiczbaRzymska ciagNegative = new LiczbaRzymska(-2);
	
	@Test
	public void testToStringProper() {
		assertEquals("IX", ciag.toString());
		assertEquals("VI", ciag2.toString());
	}
	
	@Test
	public void testTooBigNumber() {
		assertEquals("Zla liczba!", ciagTooBig.toString());
	}
	
	@Test
	public void testNegativeNumber() {
		assertEquals("Zla liczba!", ciagNegative.toString());
	}
}
