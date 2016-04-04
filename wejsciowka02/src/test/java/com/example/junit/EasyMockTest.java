package com.example.junit;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EasyMockTest {

	private static final int NR = 1;
	private static final int NR2 = 2;
	private static final String NAZWA = "Cargo";
	private static final String NAZWA2 = "Arriva";
	private static final String TYP = "Osobowy";
	
	private TrainManager trainManager;
	private IMyList mock;
	private Train train = new Train(TYP, NAZWA, NR);
	private Train train2 = new Train(TYP, NAZWA2, NR2);
	private List<Train> trains = new ArrayList<Train>();
	
	@Before
	public void setUp() {
		mock = createMock(IMyList.class);
		trainManager = new TrainManager(mock);
	}

	@Test
	public void checkAdding() {
		expect(mock.addTrain(train)).andReturn(true).atLeastOnce();
		replay(mock);
		assertTrue(trainManager.addTrain(train));
		verify(mock);
	}
	
	@Test
	public void checkRemove() {
		expect(mock.deleteTrain(train)).andReturn(true).atLeastOnce();
		replay(mock);
		assertTrue(trainManager.deleteTrain(train));
		verify(mock);
	}

	
	
	@Test
	public void checkGetByNr() {
		expect(mock.getByNr(NR)).andReturn(train);
		replay(mock);
		assertEquals(train, trainManager.getByNr(NR));
		verify(mock);
	}
	@Test
	public void checkGetByNazwa() {
		expect(mock.getByNazwa(NAZWA)).andReturn(train);
		replay(mock);
		assertEquals(train, trainManager.getByNazwa(NAZWA));
		verify(mock);
	}
	
	@Test
	public void checkGetAll() {
		trains.add(train);
		trains.add(train2);
		expect(mock.getAll()).andReturn(trains);
		replay(mock);
		assertEquals(trains, trainManager.getAllTrains());
		verify(mock);
	}
}
