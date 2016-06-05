package com.example.restservicedemo;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.jayway.restassured.RestAssured;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class CarServiceTest {
	
	private static Car c1;
	private static Car c2;
	private static Car c3;

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restservicedemo/api";
		c1 = new Car("Mazda", 1999);
		c2 = new Car("Opel", 2016);
		c3 = new Car("Audi", 2010);
    }
    
	@Before
	@After
	public void clearDB(){
		delete("/car/").then().assertThat().statusCode(200);
		delete("/person/").then().assertThat().statusCode(200);
	}
	
    @Test
    public void addCars() throws JSONException {

        given().
                contentType(MediaType.APPLICATION_JSON).
                body(c1).
                when().
                post("/car/add").then().assertThat().statusCode(201);


        String cars = get("/car/all").asString();

        HashMap<Car, Person> returnedCars = from(cars).get("car");

        JSONObject json = new JSONObject(returnedCars);

        Car rCar = get("/car/" + json.get("id")).as(Car.class);

        assertThat(c1.getModel(), equalToIgnoringCase(rCar.getModel()));
    }

	@Test
	public void getAllCars(){

		given().
				contentType(MediaType.APPLICATION_JSON).
				body(c1).
				when().
				post("/car/add").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(c2).
				when().
				post("/car/add").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(c3).
				when().
				post("/car/add").then().assertThat().statusCode(201);

		String result = get("/car/all/").asString();

		List<Car> cars = from(result).get("car");

		assertNotNull(cars);
		assertEquals(3, cars.size());

	}

}