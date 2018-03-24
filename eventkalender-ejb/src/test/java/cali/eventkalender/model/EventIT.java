package cali.eventkalender.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EventIT {
	
	@Test
	public void getNation() {
		Event event = new Event();

		assertEquals(null, event.getNation());
	}
	
	@Test
	public void setNation() {
		Nation nation = new Nation();
		
		Event event = new Event();
		event.setNation(nation);

		assertEquals(nation, event.getNation());
	}
	
	@Test
	public void getPersons() {
		Event event = new Event();

		assertEquals(0, event.getPersons().size());
	}

	@Test
	public void setPersons() {
		Event event = new Event();
		Person person = new Person("TESTFÖRNAMN", "TESTEFTERNAMN");
		Set<Person> persons = new LinkedHashSet<>(Arrays.asList(person));
		event.setPersons(persons);

		assertEquals(1, event.getPersons().size());
		for (Person p : event.getPersons()) {
			assertTrue(p.getEvents().contains(event));
		}
	}
	
	@Test
	public void addPerson() {
		Event event = new Event();
		Person person = new Person("TESTFÖRNAMN", "TESTEFTERNAMN");
		person.setId(Long.MAX_VALUE);
		
		event.addPerson(person);
		
		assertEquals(1, event.getPersons().size());
		assertEquals(1, person.getEvents().size());
		assertTrue(person.getEvents().contains(event));
	}
	
	@Test
	public void addPersonAlreadyExists() {
		Event event = new Event();
		Person person = new Person("TESTFÖRNAMN", "TESTEFTERNAMN");
		person.setId(Long.MAX_VALUE);
		
		event.addPerson(person);
		event.addPerson(person);
		
		assertEquals(1, event.getPersons().size());
		assertEquals(1, person.getEvents().size());
		assertTrue(person.getEvents().contains(event));
	}
	
	@Test
	public void addPersonWithNullObject() {
		Event event = new Event();

		event.addPerson(null);
		
		assertEquals(0, event.getPersons().size());
	}
	
	@Test
	public void deletePersonWithId() {
		Event event = new Event();
		Person person = new Person("TESTFÖRNAMN", "TESTEFTERNAMN");
		person.setId(Long.MAX_VALUE);
		
		event.addPerson(person);
		event.deletePerson(Long.MAX_VALUE);
		
		assertEquals(0, event.getPersons().size());
		assertEquals(0, person.getEvents().size());
	}
	
	@Test
	public void deletePersonWithIdNoMatch() {
		Event event = new Event();
		Person person = new Person("TESTFÖRNAMN", "TESTEFTERNAMN");
		person.setId(Long.MAX_VALUE);
		
		event.addPerson(person);
		event.deletePerson(-1);
		
		assertEquals(1, event.getPersons().size());
		assertEquals(1, person.getEvents().size());
	}
	
	@Test
	public void deletePersonWithObject() {
		Event event = new Event();
		Person person = new Person("TESTFÖRNAMN", "TESTEFTERNAMN");
		person.setId(Long.MAX_VALUE);
		
		event.addPerson(person);
		event.deletePerson(person);
		
		assertEquals(0, event.getPersons().size());
		assertEquals(0, person.getEvents().size());
	}
	
	@Test
	public void deletePersonWithObjectNoMatch() {
		Event event = new Event();
		Person person = new Person("TESTFÖRNAMN", "TESTEFTERNAMN");
		person.setId(Long.MAX_VALUE);
		
		event.addPerson(person);
		event.deletePerson(null);
		
		assertEquals(1, event.getPersons().size());
		assertEquals(1, person.getEvents().size());
	}

}
