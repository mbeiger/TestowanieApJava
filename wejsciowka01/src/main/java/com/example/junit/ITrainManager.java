package com.example.junit;
import java.util.List;

public interface ITrainManager {
	
	boolean removeTrain(Train train);
	boolean addTrain(Train train);	
	List<Train> getAll();	
	boolean findbyNazwa(String nazwa);
	boolean findbyNumer(int numer);
}
