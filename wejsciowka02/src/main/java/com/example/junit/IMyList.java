package com.example.junit;
import java.util.List;

public interface IMyList {
	
	boolean addTrain(Train train);
	boolean deleteTrain(Train train);
	public List<Train> getAll();
	public Train getByNazwa(String nazwa);
	public Train getByNr(int nr);
	

}
