package com.example.junit;

import java.util.ArrayList;
import java.util.List;


public class TrainManager {

	List<Train> trains = new ArrayList<Train>();


	public void addTrain(Train train){

		trains.add(train);

	}

	public void removeTrain(Train train){

		trains.remove(train);

	}
	public List<Train> getAll(){
		return trains;
	}
	public boolean findbyNazwa(String nazwa)
	{
		for(Train train: trains)
		{
			if(train.getNazwa().equals(nazwa))
			{
				return true;
			}
		}
		return false;
	}
	public boolean findbyNumer(int numer)
	{
		for(Train train: trains)
		{
			if(train.getNumer()==numer)
			{
				return true;
			}
		}
		return false;
	}
}
