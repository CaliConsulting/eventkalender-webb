package cali.eventkalender.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EventIT {
	
    private Long expectedEventId;
    private String expectedEventName;
    private String expectedEventSummary;
    private LocalDateTime expectedEventStartTime;
    private LocalDateTime expectedEventEndTime;
    
    private Event expectedEvent;
    
    private Long expectedNationId;
    private String expectedNationName;
    
    private Nation expectedNation;
    
    private Long expectedPersonId;
    private String expectedPersonFirstName;
    private String expectedPersonLastName;
    
    private Person expectedPerson;
    
    @Before
    public void setup() {
        expectedNationId = -1L;
        expectedNationName = "TESTNATION";
        expectedNation = new Nation(expectedNationName);
        expectedNation.setId(expectedNationId);
        
        expectedEventId = Long.MIN_VALUE;
        expectedEventName = "TESTEVENT";
        expectedEventSummary = "TESTSAMMANFATTNING";
        expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
        expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
        expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime, expectedEventEndTime);
        expectedEvent.setId(expectedEventId);
        expectedEvent.setNation(expectedNation);
        
        expectedPersonId = Long.MAX_VALUE;
        expectedPersonFirstName = "FÖRNAMN";
        expectedPersonLastName = "EFTERNAMN";
        expectedPerson = new Person(expectedPersonFirstName, expectedPersonLastName);
        expectedPerson.setId(expectedPersonId);
    }
    
	@Test
	public void getNation() {
		assertEquals(expectedNation, expectedEvent.getNation());
	}
	
	@Test
	public void setNation() {
		assertEquals(expectedNation, expectedEvent.getNation());
		assertEquals(1, expectedNation.getEvents().size());
	}
	
	@Test
	public void getPersons() {
		assertEquals(0, expectedEvent.getPersons().size());
	}

	@Test
	public void setPersons() {
		List<Person> persons = new ArrayList<>(Arrays.asList(expectedPerson));
		expectedEvent.setPersons(persons);

		assertEquals(1, expectedEvent.getPersons().size());
		for (Person p : expectedEvent.getPersons()) {
			assertTrue(p.getEvents().contains(expectedEvent));
		}
	}
	
	@Test
	public void addPerson() {
		expectedEvent.addPerson(expectedPerson);
		
		assertEquals(1, expectedEvent.getPersons().size());
		assertEquals(1, expectedPerson.getEvents().size());
		assertTrue(expectedPerson.getEvents().contains(expectedEvent));
	}
	
	@Test
	public void addPersonAlreadyExists() {
	    expectedEvent.addPerson(expectedPerson);
	    expectedEvent.addPerson(expectedPerson);
		
		assertEquals(1, expectedEvent.getPersons().size());
		assertEquals(1, expectedPerson.getEvents().size());
		assertTrue(expectedPerson.getEvents().contains(expectedEvent));
	}
	
	@Test
	public void addPersonWithNullObject() {
	    expectedEvent.addPerson(null);
		
		assertEquals(0, expectedEvent.getPersons().size());
	}
	
	@Test
	public void deletePersonWithId() {
	    expectedEvent.addPerson(expectedPerson);
	    expectedEvent.deletePerson(expectedPersonId);
		
		assertEquals(0, expectedEvent.getPersons().size());
		assertEquals(0, expectedPerson.getEvents().size());
	}
	
	@Test
	public void deletePersonWithIdNoMatch() {
		expectedEvent.addPerson(expectedPerson);
		expectedEvent.deletePerson(-1);
		
		assertEquals(1, expectedEvent.getPersons().size());
		assertEquals(1, expectedPerson.getEvents().size());
	}
	
	@Test
	public void deletePersonWithObject() {
	    expectedEvent.addPerson(expectedPerson);
	    expectedEvent.deletePerson(expectedPerson);
		
		assertEquals(0, expectedEvent.getPersons().size());
		assertEquals(0, expectedPerson.getEvents().size());
	}
	
	@Test
	public void deletePersonWithObjectNoMatch() {
	    expectedEvent.addPerson(expectedPerson);
	    expectedEvent.deletePerson(null);
		
		assertEquals(1, expectedEvent.getPersons().size());
		assertEquals(1, expectedPerson.getEvents().size());
	}

}
