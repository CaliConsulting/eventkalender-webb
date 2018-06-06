package cali.eventkalender.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NationIT {

	private Long expectedEventId;
	private String expectedEventName;
	private String expectedEventSummary;
	private LocalDateTime expectedEventStartTime;
	private LocalDateTime expectedEventEndTime;

	private Event expectedEvent;

	private Long expectedNationId;
	private String expectedNationName;

	private Nation expectedNation;

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
		expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime,
				expectedEventEndTime);
		expectedEvent.setId(expectedEventId);
	}

	@Test
	public void getEvents() {
		assertEquals(0, expectedNation.getEvents().size());
	}

	@Test
	public void setEvents() {
		List<Event> events = new ArrayList<>(Arrays.asList(expectedEvent));
		expectedNation.setEvents(events);

		assertEquals(1, expectedNation.getEvents().size());
		for (Event e : expectedNation.getEvents()) {
			assertEquals(expectedNation, e.getNation());
		}
	}

	@Test
	public void addEvent() {
		expectedNation.addEvent(expectedEvent);

		assertEquals(1, expectedNation.getEvents().size());
		assertEquals(expectedNation, expectedEvent.getNation());
	}

	@Test
	public void addEventAlreadyExists() {
		expectedNation.addEvent(expectedEvent);
		expectedNation.addEvent(expectedEvent);

		assertEquals(1, expectedNation.getEvents().size());
		assertEquals(expectedNation, expectedEvent.getNation());
	}

	@Test
	public void addEventWithNullObject() {
		expectedNation.addEvent(null);

		assertEquals(0, expectedNation.getEvents().size());
	}

	@Test
	public void addEventExistsOnAnotherNation() {
		expectedNation.addEvent(expectedEvent);

		Nation newNation = new Nation();
		newNation.addEvent(expectedEvent);

		assertEquals(0, expectedNation.getEvents().size());
		assertEquals(1, newNation.getEvents().size());
		assertEquals(newNation, expectedEvent.getNation());
	}

	@Test
	public void deleteEventWithId() {
		expectedNation.addEvent(expectedEvent);
		expectedNation.deleteEvent(expectedEventId);

		assertEquals(0, expectedNation.getEvents().size());
		assertNull(expectedEvent.getNation());
	}

	@Test
	public void deleteEventWithIdNoMatch() {
		expectedNation.addEvent(expectedEvent);
		expectedNation.deleteEvent(-1);

		assertEquals(1, expectedNation.getEvents().size());
		assertEquals(expectedNation, expectedEvent.getNation());
	}

	@Test
	public void deleteEventWithObject() {
		expectedNation.addEvent(expectedEvent);
		expectedNation.deleteEvent(expectedEvent);

		assertEquals(0, expectedNation.getEvents().size());
		assertNull(expectedEvent.getNation());
	}

	@Test
	public void deleteEventWithObjectNoMatch() {
		expectedNation.addEvent(expectedEvent);
		expectedNation.deleteEvent(null);

		assertEquals(1, expectedNation.getEvents().size());
		assertEquals(expectedNation, expectedEvent.getNation());
	}

}
