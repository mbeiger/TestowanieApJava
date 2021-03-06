package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbcdemo.domain.Person;

public class PersonManager {

	private Connection connection;

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";

	private String createTablePerson = "CREATE TABLE Person(id bigint GENERATED BY DEFAULT AS IDENTITY, name varchar(20), yob integer)";

	private PreparedStatement addPersonStmt;
	private PreparedStatement deleteAllPersonsStmt;
	private PreparedStatement deletePersonStmt;
	private PreparedStatement getAllPersonsStmt;
	private PreparedStatement updatePersonStmt;
	private PreparedStatement getPersonByYobStmt;



	
	private Statement statement;

	public PersonManager() {
		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Person".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTablePerson);

			addPersonStmt = connection
					.prepareStatement("INSERT INTO Person (name, yob) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			deleteAllPersonsStmt = connection
					.prepareStatement("DELETE FROM Person");
			deletePersonStmt = connection
					.prepareStatement("DELETE FROM Person WHERE name=? AND yob=?");
			getAllPersonsStmt = connection
					.prepareStatement("SELECT id, name, yob FROM Person");
			updatePersonStmt = connection
					.prepareStatement("UPDATE Person SET name=?, yob=? WHERE id=?");
			getPersonByYobStmt = connection
					.prepareStatement("SELECT id, name, yob FROM Person WHERE yob=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}

	void clearPersons() {
		try {
			deleteAllPersonsStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int deletePerson(Person person) {
		int count = 0;
		try {
			deletePersonStmt.setString(1, person.getName());
			deletePersonStmt.setInt(2, person.getYob());

			count = deletePersonStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public int addPerson(Person person) {
		int count = 0;
		try {
			addPersonStmt.setString(1, person.getName());
			addPersonStmt.setInt(2, person.getYob());

			count = addPersonStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
		public int addPersonGetID(Person person) {
		int count = 0, key = 0;
		try {
			addPersonStmt.setString(1, person.getName());
			addPersonStmt.setInt(2, person.getYob());

			count = addPersonStmt.executeUpdate();
			ResultSet rs = addPersonStmt.getGeneratedKeys();
			if (rs.next()){
				key = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
	}

	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList<Person>();

		try {
			ResultSet rs = getAllPersonsStmt.executeQuery();

			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setYob(rs.getInt("yob"));
				persons.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}
 
	public int updatePerson(int id, Person person) {
		int count = 0;
		try {
			updatePersonStmt.setString(1, person.getName());
			updatePersonStmt.setInt(2, person.getYob());
			updatePersonStmt.setInt(3, id);

			count = updatePersonStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Person> getPersonByYob(int yob) {
		List<Person> persons = new ArrayList<Person>();

		try {
			getPersonByYobStmt.setInt(1, yob);
			ResultSet rs = getPersonByYobStmt.executeQuery();

			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setYob(rs.getInt("yob"));
				persons.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return persons;
	}
	
}
