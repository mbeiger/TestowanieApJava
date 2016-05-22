package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Person;

public class PersonManagerTest {
	
	
	PersonManager personManager = new PersonManager();
	
	private final static String NAME_1 = "Zenek";
	private final static int YOB_1 = 1945;
	private final static String NAME_2 = "Franek";
	private final static int YOB_2 = 1945;
	private final static String NAME_3 = "Tadeusz";
	private final static int YOB_3 = 1956;
	
	@Test
	public void checkConnection(){
		assertNotNull(personManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Person person = new Person(NAME_1, YOB_1);
		
		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person));

		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);
		
		assertEquals(NAME_1, personRetrieved.getName());
		assertEquals(YOB_1, personRetrieved.getYob());
		
	}

	@Test
	public void checkUpdating(){
		
		Person person1 = new Person(NAME_1, YOB_1);
		Person person2 = new Person(NAME_2, YOB_2);
		Person person3 = new Person(NAME_3, YOB_3);
		
		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person1));
		assertEquals(1,personManager.addPerson(person2));
		assertEquals(1,personManager.addPerson(person3));
		
		int id = personManager.addPersonGetID(person1);
		assertEquals(1, personManager.updatePerson(id, person2));
		
		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(3);
		
		assertEquals(NAME_2, personRetrieved.getName());
		assertEquals(YOB_2, personRetrieved.getYob());
		
	}
	@Test
	public void checkDeletePerson(){
		
		Person person = new Person(NAME_1, YOB_1);
		Person person2 = new Person(NAME_2, YOB_2);

		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person));
		assertEquals(1,personManager.addPerson(person2));
		assertEquals(1,personManager.addPerson(person2));
		assertEquals(1,personManager.addPerson(person2));


		assertEquals(3,personManager.deletePerson(person2));
		assertEquals(1,personManager.getAllPersons().size());
		
		List<Person> persons = personManager.getAllPersons();
		Person personRetrieved = persons.get(0);
		
		assertEquals(NAME_1, personRetrieved.getName());
		assertEquals(YOB_1, personRetrieved.getYob());

	}
	@Test
	public void checkDeleteAllPersons(){
		
		Person person = new Person(NAME_1, YOB_1);
		Person person2 = new Person(NAME_2, YOB_2);
		Person person3 = new Person(NAME_3, YOB_3);


		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person));
		assertEquals(1,personManager.addPerson(person2));
		assertEquals(1,personManager.addPerson(person3));


		personManager.clearPersons();
		assertEquals(0,personManager.getAllPersons().size());

	}
	@Test
	public void checkSelectingByYob(){
		
		Person person = new Person(NAME_1, YOB_1);
		Person person2 = new Person(NAME_2, YOB_2);
		Person person3 = new Person(NAME_3, YOB_3);
		
		
		
		personManager.clearPersons();
		assertEquals(1,personManager.addPerson(person));
		assertEquals(1,personManager.addPerson(person3));
		assertEquals(1,personManager.addPerson(person2));

		
		assertEquals(2,personManager.getPersonByYob(YOB_1).size());
		
	}
}
