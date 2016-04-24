package com.example;

import java.util.*;

public class TrainManager
{
	private ArrayList<Train> trains = new ArrayList<Train>();
	public void addTrain(Train train)
	{
		trains.add(train);
	}
	public void removeTrain(Train train)
	{
		trains.remove(train);
	}
	public Train getTrain(int nr)
	{
		return trains.get(nr);
	}
	public Train getTrain(Train train)
	{
		int index = trains.indexOf(train);
		return trains.get(index);
	}
	public List<Train> getAllTrains()
	{
		return trains;
	}
}           
