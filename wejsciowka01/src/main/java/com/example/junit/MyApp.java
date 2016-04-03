package com.example.junit;
import java.util.List;
public class MyApp {
	
	private ITrainManager trainm;

	public MyApp(ITrainManager trainm) {
		this.trainm = trainm;
	}
	
	public boolean addTrain(Train train){
		return trainm.addTrain(train);	
	}
	
	public boolean removeTrain(Train train){
		return trainm.removeTrain(train);
	}
	public List<Train> getAll()
	{
		return trainm.getAll();
	}
	public boolean findbyNazwa(String nazwa)
	{
		return trainm.findbyNazwa(nazwa);
	}
	public boolean findbyNumer(int numer)
	{
		return trainm.findbyNumer(numer);
	}
}
