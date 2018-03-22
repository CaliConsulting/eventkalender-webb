package cali.eventkalender.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NationIT {

	@Test
	public void getEvents() {
		Nation nation = new Nation();

		assertEquals(0, nation.getEvents().size());
	}

	@Test
	public void setEvents() {
		Nation nation = new Nation();
		Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", LocalDateTime.now(), LocalDateTime.now());
		Set<Event> events = new LinkedHashSet<>(Arrays.asList(event));
		nation.setEvents(events);

		assertEquals(1, nation.getEvents().size());
		for (Event e : nation.getEvents()) {
			assertEquals(nation, e.getNation());
		}
	}

	@Test
	public void addEvent() {
		Nation nation = new Nation("TESTNATION");
		Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", LocalDateTime.now(), LocalDateTime.now());
		event.setId(Long.MAX_VALUE);

		nation.addEvent(event);

		assertEquals(1, nation.getEvents().size());
		assertEquals(nation, event.getNation());
	}

	@Test
	public void addEventWithNullObject() {
		Nation nation = new Nation("TESTNATION");

		nation.addEvent(null);

		assertEquals(0, nation.getEvents().size());
	}

	@Test
	public void addEventExistsOnAnotherNation() {
		Nation existingNation = new Nation("TESTNATION");
		Event existingEvent = new Event("TESTEVENT", "TESTSAMMANFATTNING", LocalDateTime.now(), LocalDateTime.now());
		existingNation.addEvent(existingEvent);

		Nation newNation = new Nation();
		newNation.addEvent(existingEvent);

		assertEquals(0, existingNation.getEvents().size());
		assertEquals(1, newNation.getEvents().size());
	}

	@Test
	public void deleteEventWithId() {
		Nation nation = new Nation("TESTNATION");
		Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", LocalDateTime.now(), LocalDateTime.now());
		event.setId(Long.MAX_VALUE);

		nation.addEvent(event);
		nation.deleteEvent(Long.MAX_VALUE);

		assertEquals(0, nation.getEvents().size());
		assertEquals(null, event.getNation());
	}

	@Test
	public void deleteEventWithIdNoMatch() {
		Nation nation = new Nation("TESTNATION");
		Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", LocalDateTime.now(), LocalDateTime.now());
		event.setId(Long.MAX_VALUE);

		nation.addEvent(event);
		nation.deleteEvent(-1);

		assertEquals(1, nation.getEvents().size());
		assertEquals(nation, event.getNation());
	}

	@Test
	public void deleteEventWithObject() {
		Nation nation = new Nation();

		Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", LocalDateTime.now(), LocalDateTime.now());
		event.setId(Long.MAX_VALUE);

		nation.addEvent(event);
		nation.deleteEvent(event);

		assertEquals(0, nation.getEvents().size());
		assertEquals(null, event.getNation());
	}

	@Test
	public void deleteEventWithObjectNoMatch() {
		Nation nation = new Nation("TESTNATION");
		Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", LocalDateTime.now(), LocalDateTime.now());
		event.setId(Long.MAX_VALUE);

		nation.addEvent(event);
		nation.deleteEvent(null);

		assertEquals(1, nation.getEvents().size());
		assertEquals(nation, event.getNation());
	}

}
