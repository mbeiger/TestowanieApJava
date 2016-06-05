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


public class PersonServiceTest {
	
	private static Person p1;
	private static Person p2;
	private static Person p3;

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restservicedemo/api";
		p1 = new Person("Kowalski", 1980);
		p2 = new Person("Nowak", 1985);
		p3 = new Person("Kowal", 1950);
    }
    
	@Before
	@After
	public void clearDB(){
		delete("/car/").then().assertThat().statusCode(200);
		delete("/person/").then().assertThat().statusCode(200);
	}
	
    @Test
    public void addPersons() throws JSONException {


	delete("/person/").then().assertThat().statusCode(200);

	given().
       contentType(MediaType.APPLICATION_JSON).
       body(p1).
    when().	     
    post("/person/add").then().assertThat().statusCode(201);

	String persons = get("/person/all").asString();

	HashMap<Car, Person> returnedCars = from(persons).get("person");

	JSONObject json = new JSONObject(returnedCars);


	Person rPerson = get("/person/" + json.get("id")).as(Person.class);
	
	assertThat(p1.getFirstName(), equalToIgnoringCase(rPerson.getFirstName()));
    }

	@Test
	public void getAllPersons(){

		given().
				contentType(MediaType.APPLICATION_JSON).
				body(p1).
				when().
				post("/person/add").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(p2).
				when().
				post("/person/add").then().assertThat().statusCode(201);
		given().
				contentType(MediaType.APPLICATION_JSON).
				body(p3).
				when().
				post("/person/add").then().assertThat().statusCode(201);

		String result = get("/person/all/").asString();

		List<Car> persons = from(result).get("person");

		assertNotNull(persons);
		assertEquals(3, persons.size());
	}
}