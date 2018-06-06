package cali.eventkalender.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
public class PersonIT {

	private Long expectedEventId;
	private String expectedEventName;
	private String expectedEventSummary;
	private LocalDateTime expectedEventStartTime;
	private LocalDateTime expectedEventEndTime;

	private Event expectedEvent;

	private Long expectedPersonId;
	private String expectedPersonFirstName;
	private String expectedPersonLastName;

	private Person expectedPerson;

	@Before
	public void setup() {
		expectedPersonId = -1L;
		expectedPersonFirstName = "TESTPERSONFIRSTNAME";
		expectedPersonLastName = "TESTPERSONLASTNAME";
		expectedPerson = new Person(expectedPersonFirstName, expectedPersonLastName);
		expectedPerson.setId(expectedPersonId);

		expectedEventId = Long.MIN_VALUE;
		expectedEventName = "TESTEVENT";
		expectedEventSummary = "TESTSAMMANFATTNING";
		expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
		expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
		expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime,
				expectedEventEndTime);
		expectedEvent.setId(expectedEventId);
	}

	@Test
	public void getEvents() {
		assertEquals(0, expectedPerson.getEvents().size());
	}

	@Test
	public void setEvents() {
		List<Event> events = new ArrayList<>(Arrays.asList(expectedEvent));
		expectedPerson.setEvents(events);

		assertEquals(1, expectedPerson.getEvents().size());
		assertTrue(expectedEvent.getPersons().contains(expectedPerson));
	}

	@Test
	public void addEvent() {
		expectedPerson.addEvent(expectedEvent);

		assertEquals(1, expectedPerson.getEvents().size());
		assertTrue(expectedEvent.getPersons().contains(expectedPerson));
	}

	@Test
	public void addEventAlreadyExists() {
		expectedPerson.addEvent(expectedEvent);
		expectedPerson.addEvent(expectedEvent);

		assertEquals(1, expectedPerson.getEvents().size());
		assertTrue(expectedEvent.getPersons().contains(expectedPerson));
	}

	@Test
	public void addEventWithNullObject() {
		expectedPerson.addEvent(null);

		assertEquals(0, expectedPerson.getEvents().size());
	}

	@Test
	public void deleteEventWithId() {
		expectedPerson.addEvent(expectedEvent);
		expectedPerson.deleteEvent(expectedEventId);

		assertEquals(0, expectedPerson.getEvents().size());
		assertFalse(expectedEvent.getPersons().contains(expectedPerson));
	}

	@Test
	public void deleteEventWithIdNoMatch() {
		expectedPerson.addEvent(expectedEvent);
		expectedPerson.deleteEvent(-1);

		assertEquals(1, expectedPerson.getEvents().size());
		assertTrue(expectedEvent.getPersons().contains(expectedPerson));
	}

	@Test
	public void deleteEventWithObject() {
		expectedPerson.addEvent(expectedEvent);
		expectedPerson.deleteEvent(expectedEvent);

		assertEquals(0, expectedPerson.getEvents().size());
		assertFalse(expectedEvent.getPersons().contains(expectedPerson));
	}

	@Test
	public void deleteEventWithObjectNoMatch() {
		expectedPerson.addEvent(expectedEvent);
		expectedPerson.deleteEvent(null);

		assertEquals(1, expectedPerson.getEvents().size());
		assertTrue(expectedEvent.getPersons().contains(expectedPerson));
	}

}
