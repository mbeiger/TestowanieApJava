package com.example.junit;

import java.util.ArrayList;
import java.util.List;

public class TrainManager {
	
	public IMyList myList;
	
	public TrainManager(IMyList myList){
		this.myList = myList;
	}
	
	public boolean addTrain(Train train){
		return myList.addTrain(train);
	}
	
	public boolean deleteTrain(Train train){
		return myList.deleteTrain(train);
	}
	
	public List<Train> getAllTrains(){
		return myList.getAll();
	}
	
	public Train getByNazwa(String nazwa){
		return myList.getByNazwa(nazwa);
	}
	
	public Train getByNr(int nr){
		return myList.getByNr(nr);
	}
}
