package com.example.restservicedemo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.example.restservicedemo.domain.Car;
import com.example.restservicedemo.domain.Person;
import com.example.restservicedemo.service.CarManager;
import com.example.restservicedemo.service.PersonManager;

public class BLTest {
	private static Person p1;
	private static Person p2;
	private static Person p3;
	private static Car c1;
	private static Car c2;
	private static Car c3;
	
	private static CarManager cm = new CarManager();
	private static PersonManager pm = new PersonManager();
	@BeforeClass
	public static void setUp() {
		p1 = new Person("Kowalski", 1980);
		p2 = new Person("Nowak", 1985);
		p3 = new Person("Kowal", 1950);
		c1 = new Car("Mazda", 1999);
		c2 = new Car("Opel", 2016);
		c3 = new Car("Audi", 2010);
	}
	@Before
	@After
	public void cleanTables() {
		cm.clearCars();
		pm.clearPersons();
	}
	@Test
	public void addPerson() {
		assertEquals(1, pm.addPerson(p1));
		
	}	
	@Test
	public void getAllPersons() {

		pm.addPerson(p1);
		pm.addPerson(p2);
		pm.addPerson(p3);

		List<Person> persons = new ArrayList<>();

		persons = pm.getAllPersons();

		assertEquals(3, persons.size());
		assertNotEquals(persons.get(0), persons.get(1));
		assertNotEquals(persons.get(1), persons.get(2));

		assertEquals(p1.getFirstName(), persons.get(0).getFirstName());
		assertEquals(p2.getFirstName(), persons.get(1).getFirstName());
		assertEquals(p3.getFirstName(), persons.get(2).getFirstName());
	}
	@Test
	public void getPersonByFirstName() {
		pm.addPerson(p1);
		Person answer = pm.getPersonFromFirstName(p1.getFirstName());
		assertEquals(true, answer.hasId());
		assertEquals(p1.getFirstName(), answer.getFirstName());
		assertEquals(p1.getYob(), answer.getYob());
	}
	@Test
	public void getPersonById() {
		pm.addPerson(p1);
		Person answer2 = pm.getPersonFromFirstName(p1.getFirstName());
		assertEquals(true, answer2.hasId());

		Person answer = pm.getPerson(answer2.getId());

		assertEquals(p1.getFirstName(), answer.getFirstName());
		assertEquals(p1.getYob(), answer.getYob());
	}	
	@Test
	public void deletePerson() {
		pm.addPerson(p1);
		Person answer2 = pm.getPersonFromFirstName(p1.getFirstName());
		assertEquals(true, answer2.hasId());

		Person answer = pm.getPerson(answer2.getId());

		List<Person> persons;
		persons = pm.getAllPersons();
		assertEquals(1, persons.size());

		pm.removePerson(answer.getId());
		persons = pm.getAllPersons();
		assertEquals(0, persons.size());

		pm.addPerson(p1);
		pm.addPerson(p2);
		pm.addPerson(p3);
		persons = pm.getAllPersons();
		assertEquals(3, persons.size());

		answer = pm.getPersonFromFirstName(p1.getFirstName());
		pm.removePerson(answer.getId());
		persons = pm.getAllPersons();
		assertEquals(2, persons.size());
	}
	@Test
	public void addCar() {
		assertEquals(1, cm.addCar(c1));
	}

	@Test
	public void getAllCars() {

		cm.addCar(c1);
		cm.addCar(c2);
		cm.addCar(c3);

		List<Car> cars;

		cars = cm.getAllCars();

		assertEquals(3, cars.size());
		assertNotEquals(cars.get(0), cars.get(1));
		assertNotEquals(cars.get(1), cars.get(2));

		assertEquals(c1.getModel(), cars.get(0).getModel());
		assertEquals(c2.getModel(), cars.get(1).getModel());
		assertEquals(c3.getModel(), cars.get(2).getModel());
	}
	@Test
	public void sellCarAndGetCarWithOwner() {

		pm.addPerson(p1);
		pm.addPerson(p2);
		pm.addPerson(p3);
		cm.addCar(c1);
		cm.addCar(c2);

		List<Person> persons = pm.getAllPersons();
		assertEquals(true, persons.get(0).hasId());
		assertEquals(true, persons.get(1).hasId());
		assertEquals(true, persons.get(2).hasId());

		List<Car> cars = cm.getAllCars();
		assertEquals(true, cars.get(0).hasId());
		assertEquals(true, cars.get(1).hasId());


		assertEquals(1, cm.sellCar(cars.get(0), persons.get(0)));

		Car answer = cm.getCarWithOwner(cars.get(0));

		assertEquals(persons.get(0).getFirstName(), answer.getOwner().getFirstName());
		assertEquals(persons.get(0).getYob(), answer.getOwner().getYob());

	}	
	@Test
	public void getPersonsWithCars() {

		pm.addPerson(p1);
		pm.addPerson(p2);
		pm.addPerson(p3);
		cm.addCar(c1);
		cm.addCar(c2);

		
		List<Person> persons = pm.getAllPersons();

		List<Car> cars = cm.getAllCars();


		assertEquals(1, cm.sellCar(cars.get(0), persons.get(0)));
		assertEquals(1, cm.sellCar(cars.get(1), persons.get(1)));

		Map<Person, List<Car>> answer = pm.getPersonWithCar();

		assertTrue(answer.size() == 2);
	}	
}
