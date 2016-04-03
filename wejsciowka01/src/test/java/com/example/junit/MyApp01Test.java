package com.example.junit;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyApp01Test {

	// SUT
	private MyApp myApp;
	private ITrainManager mock;

	@Before
	public void setUp() {
		mock = createMock(ITrainManager.class);
		myApp = new MyApp(mock);
	}

	@Test
	public void addingCheck() {
		
		Train pociag = new Train("Cargo", true, 3);
		List<Train> trains = new ArrayList<Train>();
		trains.add(pociag);
		
		
		expect(mock.addTrain(pociag)).andReturn(true).atLeastOnce();
				
		expect(mock.removeTrain(pociag)).andReturn(true).atLeastOnce();
		
		expect(mock.getAll()).andReturn(trains).atLeastOnce();
		
		expect(mock.findbyNazwa("Cargo")).andReturn(true).atLeastOnce();

		expect(mock.findbyNumer(3)).andReturn(true).atLeastOnce();

		
		replay(mock);
		
		assertEquals(true, myApp.addTrain(pociag));
		assertEquals("Cargo", myApp.getAll().get(0).getNazwa());
		assertEquals(true, myApp.removeTrain(pociag));
		assertEquals(true, myApp.findbyNazwa("Cargo"));
		assertEquals(true, myApp.findbyNumer(3));


		verify(mock);
	}
}
