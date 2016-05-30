package com.example.junit;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TrainSteps {
	
	private TrainManager trains;
	 List<Train> trains = new ArrayList<Train>();
	
	@Given("a trainmanager")
	public void trainmanagerSetup(){
		trains = new TrainManager();
	}
	
	@When("add $train train")
	public void setArguments(int train){
		Train pociag = new Train("Osobowy", true, 1);
		for(int i=0; i<train; i++)
		{
			trains.add(pociag);
		}
	}
	
    
    @Then("getCount should return $result")
  	public void shouldgetCount(int result){
  		assertEquals(result, trains.getCount());
  	}
}
