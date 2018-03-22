package cali.eventkalender.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class NationTest {

	@Test
	public void constructorDefault() {
		Nation nation = new Nation();

		assertEquals(Long.MIN_VALUE, nation.getId());
		assertEquals(null, nation.getName());
		assertEquals(0, nation.getEvents().size());
	}

	@Test
	public void constructorValues() {
		Nation nation = new Nation("TESTNATION");

		assertEquals(Long.MIN_VALUE, nation.getId());
		assertEquals("TESTNATION", nation.getName());
		assertEquals(0, nation.getEvents().size());
	}

	@Test
	public void constructorRelations() {
		Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", LocalDateTime.now(), LocalDateTime.now());
		Set<Event> events = new LinkedHashSet<>(Arrays.asList(event));

		Nation nation = new Nation("TESTNATION", events);

		assertEquals(Long.MIN_VALUE, nation.getId());
		assertEquals("TESTNATION", nation.getName());
		assertEquals(1, nation.getEvents().size());
	}

	@Test
	public void getId() {
		Nation nation = new Nation();

		assertEquals(Long.MIN_VALUE, nation.getId());
	}

	@Test
	public void setId() {
		Nation nation = new Nation();
		nation.setId(Long.MAX_VALUE);

		assertEquals(Long.MAX_VALUE, nation.getId());
	}

	@Test
	public void getName() {
		Nation nation = new Nation();

		assertEquals(null, nation.getName());
	}

	@Test
	public void setName() {
		Nation nation = new Nation();
		nation.setName("TESTNATION");

		assertEquals("TESTNATION", nation.getName());
	}

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

	@Test
	public void equals() {
		Nation nation = new Nation();
		Nation nation2 = new Nation();

		assertEquals(nation, nation2);
	}

	@Test
	public void equalsItself() {
		Nation nation = new Nation();

		assertEquals(nation, nation);
	}

	@Test
	public void equalsOtherInstanceWithValues() {
		Nation nation = new Nation("TESTNATION");
		Nation nation2 = new Nation("TESTNATION");

		assertEquals(nation, nation2);
	}

	@Test
	public void notEqualsNull() {
		Nation nation = new Nation();

		assertNotEquals(null, nation);
	}
	
	@Test
	public void notEqualsNullParameter() {
		Nation nation = new Nation();

		assertFalse(nation.equals(null));
	}
	
	@Test
	public void notEqualsIncompatibleObject() {
		Nation nation = new Nation();
		
		assertNotEquals(new Object(), nation);
	}
	
	@Test
	public void notEqualsIncompatibleObjectParameter() {
		Nation nation = new Nation();

		assertFalse(nation.equals(new HashSet<Object>()));
	}

	@Test
	public void equalsId() {
		Nation nation = new Nation();
		Nation nation2 = new Nation();

		assertEquals(nation, nation2);
	}
	
	@Test
	public void notEqualsId() {
		Nation nation = new Nation();
		Nation nation2 = new Nation();
		nation2.setId(Long.MAX_VALUE);

		assertNotEquals(nation, nation2);
	}
	
	@Test
	public void equalsName() {
		Nation nation = new Nation("TESTNATION");
		Nation nation2 = new Nation("TESTNATION");

		assertEquals(nation, nation2);
	}
	
	@Test
	public void notEqualsName() {
		Nation nation = new Nation();
		Nation nation2 = new Nation();
		nation2.setName("ANOTHERTESTNATION");

		assertNotEquals(nation, nation2);
	}
	
	@Test
	public void equalsHashCode() {
		Nation nation = new Nation();
		Nation nation2 = new Nation();
		
		assertEquals(nation.hashCode(), nation2.hashCode());
	}
	
	@Test
	public void notEqualsHashCode() {
		Nation nation = new Nation();
		Nation nation2 = new Nation();
		nation2.setId(Long.MAX_VALUE);
		
		assertNotEquals(nation.hashCode(), nation2.hashCode());
	}
	
}

