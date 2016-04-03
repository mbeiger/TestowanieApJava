package com.example.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TrainManagerTest {


	TrainManager trainManager = new TrainManager();

	private final static String NAZWA_1 = "Osobowy";
	private final static boolean DOSTEPNY_1 = true;
	private final static int NUMER_1 = 1;

	@Test
	public void checkAdding(){

		int trainSizeBeforeAdd = 0;

		Train pociag = new Train(NAZWA_1, DOSTEPNY_1, NUMER_1);

		trainManager.addTrain(pociag);

		int trainSizeAfterAdd = trainManager.trains.size();

		int trainsSub = trainSizeAfterAdd - trainSizeBeforeAdd;

		assertEquals(1, trainsSub);

		assertEquals(NAZWA_1, trainManager.trains.get(trainManager.trains.size() - 1).getNazwa());
		assertEquals(NUMER_1, trainManager.trains.get(trainManager.trains.size() - 1).getNumer());
		assertEquals(DOSTEPNY_1, trainManager.trains.get(trainManager.trains.size() - 1).getDostepny());

	}

	@Test
	public void checkRemoving(){

		int trainSizeBeforeAdd = 0;

		Train pociag = new Train(NAZWA_1, DOSTEPNY_1, NUMER_1);

		trainManager.addTrain(pociag);

		int trainSizeAfterAdd = trainManager.trains.size();

		int trainsSub = trainSizeAfterAdd - trainSizeBeforeAdd;

		assertEquals(1, trainsSub);

		trainManager.removeTrain(pociag);

		int trainSizeAfterRemove = trainManager.trains.size();

		assertEquals(0, trainSizeAfterRemove);

	}

}
