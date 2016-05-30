package com.project.car;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.from;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.project.car.domain.Car;
import com.project.car.service.CarManager;

import javax.ws.rs.core.MediaType;


public class CarManagerRestTest{

	@BeforeClass
	public static void setUp(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/restservicedemo/api";
	}

	CarManager cm = new CarManager();

	@Test
	public void getCar(){
		get("/car/0").then().assertThat().body("model", equalTo("Ford"));

		Car aCar = get("/car/0").as(Car.class);
		assertEquals(2011, aCar.getRok());
	}

	@Test
	public void addCar(){

		delete("/car/").then().assertThat().statusCode(200);

		Car aCar = new Car("Ford", 2011);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(aCar).
				when().
				post("/car/add").then().assertThat().statusCode(201);
		System.out.println(aCar.getId());
		get("/car/0").then().assertThat().body("model", equalTo("Ford"));
	}

	@Test
	public void deleteCar(){
		Car carToDelete = get("/car/0").as(Car.class);
		cm.deleteCar(carToDelete);
		get("/car/0").then().assertThat().body("model", equalTo(null));
	}

	@Test
	public void getAllCars() {
		Car aCar = new Car("Ford", 2011);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(aCar).
				when().
				post("/car/add").then().assertThat().statusCode(201);

		String cars = get("/car/all").asString();
		List<Car> returnedCars = from(cars).get("car");
		assertNotNull(returnedCars);
	}
}