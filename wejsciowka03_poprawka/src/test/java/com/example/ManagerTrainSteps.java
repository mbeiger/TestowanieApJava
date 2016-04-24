package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.example.TrainManager;
import com.example.Train;

public class ManagerTrainSteps {
	private TrainManager manager;
	private Train train;
	
	@Given("a trainmanager")
	public void managerSetUp() {
		manager = new TrainManager();
	}
	
	@When("create train with name $nazwa with number $numer and add to trainmanager")
	public void createTrainWithNazwaAndNumer(String nazwa, int numer) {
		this.train = new Train(nazwa, numer);
		manager.addTrain(this.train);
	}
	
	@Then("size of trainmanager should be $size")
	public void checkSize(int result) {
		assertEquals(result, manager.getAllTrains().size());
	}
	
	@Then("name of train in trainmanager should be $nazwa")
	public void checkName(String nazwa) {
		assertEquals(nazwa, manager.getTrain(1).getNazwa());
	}
	
	@When("delete train with name $nazwa")
	public void checkDeleteTrain(String nazwa) {
		manager.removeTrain(train);
		assertEquals(nazwa, train.getNazwa());
	}
	
	@Then("only train with name $nazwa should remain in trainmanager and its size should be $size")
	public void checkRemainingTrain(String nazwa, int size) {
		assertEquals(nazwa, manager.getAllTrains().get(0).getNazwa());
		assertEquals(size, manager.getAllTrains().size());
	}
}
