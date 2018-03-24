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
public class EventTest {

	@Test
	public void constructorDefault() {
		Event event = new Event();

		assertEquals(Long.MIN_VALUE, event.getId());
		assertEquals(null, event.getName());
		assertEquals(null, event.getSummary());
		assertEquals(null, event.getStartTime());
		assertEquals(null, event.getEndTime());
		assertEquals(null, event.getNation());
		assertEquals(0, event.getPersons().size());
	}

	@Test
	public void constructorValues() {
		LocalDateTime now = LocalDateTime.now();
		Event event = new Event("TESTNATION", "TESTSAMMANFATTNING", now, now);

		assertEquals("TESTNATION", event.getName());
		assertEquals("TESTSAMMANFATTNING", event.getSummary());
		assertEquals(now, event.getStartTime());
		assertEquals(now, event.getEndTime());
		assertEquals(null, event.getNation());
		assertEquals(0, event.getPersons().size());
	}
	
	@Test
	public void constructorRelations() {
		Nation nation = new Nation("TESTNATION");
		
		Person person = new Person("TESTFÖRNAMN", "TESTEFTERNAMN");
		Set<Person> persons = new LinkedHashSet<>(Arrays.asList(person));
		
		LocalDateTime now = LocalDateTime.now();
		Event event = new Event("TESTNATION", "TESTSAMMANFATTNING", now, now, nation, persons);

		assertEquals("TESTNATION", event.getName());
		assertEquals("TESTSAMMANFATTNING", event.getSummary());
		assertEquals(now, event.getStartTime());
		assertEquals(now, event.getEndTime());
		assertEquals(nation, event.getNation());
		assertEquals(1, event.getPersons().size());
	}

	@Test
	public void getId() {
		Event event = new Event();

		assertEquals(Long.MIN_VALUE, event.getId());
	}

	@Test
	public void setId() {
		Event event = new Event();
		event.setId(Long.MAX_VALUE);

		assertEquals(Long.MAX_VALUE, event.getId());
	}

	@Test
	public void getName() {
		Event event = new Event();

		assertEquals(null, event.getName());
	}

	@Test
	public void setName() {
		Event event = new Event();
		event.setName("TESTNATION");

		assertEquals("TESTNATION", event.getName());
	}
	
	@Test
	public void getSummary() {
		Event event = new Event();

		assertEquals(null, event.getSummary());
	}

	@Test
	public void setSummary() {
		Event event = new Event();
		event.setSummary("TESTSAMMANFATTNING");

		assertEquals("TESTSAMMANFATTNING", event.getSummary());
	}
	
	@Test
	public void getStartTime() {
		Event event = new Event();

		assertEquals(null, event.getStartTime());
	}

	@Test
	public void setStartTime() {
		LocalDateTime now = LocalDateTime.now();
		
		Event event = new Event();
		event.setStartTime(now);

		assertEquals(now, event.getStartTime());
	}
	
	@Test
	public void getEndTime() {
		Event event = new Event();

		assertEquals(null, event.getEndTime());
	}

	@Test
	public void setEndTime() {
		LocalDateTime now = LocalDateTime.now();
		
		Event event = new Event();
		event.setEndTime(now);

		assertEquals(now, event.getEndTime());
	}

	@Test
	public void equals() {
		Event event = new Event();
		Event event2 = new Event();

		assertEquals(event, event2);
	}

	@Test
	public void equalsItself() {
		Event event = new Event();

		assertEquals(event, event);
	}

	@Test
	public void equalsOtherInstanceWithValues() {
		LocalDateTime now = LocalDateTime.now();
		Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", now, now);
		Event event2 = new Event("TESTEVENT", "TESTSAMMANFATTNING", now, now);
		
		assertEquals(event, event2);
	}

	@Test
	public void notEqualsNull() {
		Event event = new Event();

		assertNotEquals(null, event);
	}
	
	@Test
	public void notEqualsNullParameter() {
		Event event = new Event();

		assertFalse(event.equals(null));
	}
	
	@Test
	public void notEqualsIncompatibleObject() {
		Event event = new Event();
		
		assertNotEquals(new Object(), event);
	}
	
	@Test
	public void notEqualsIncompatibleObjectParameter() {
		Event event = new Event();

		assertFalse(event.equals(new HashSet<Object>()));
	}

	@Test
	public void equalsId() {
		Event event = new Event();
		Event event2 = new Event();

		assertEquals(event, event2);
	}
	
	@Test
	public void notEqualsId() {
		Event event = new Event();
		Event event2 = new Event();
		event2.setId(Long.MAX_VALUE);

		assertNotEquals(event, event2);
	}
	
	@Test
	public void equalsName() {
		Event event = new Event();
		event.setName("TESTEVENT");
		Event event2 = new Event();
		event2.setName("TESTEVENT");

		assertEquals(event, event2);
	}
	
	@Test
	public void notEqualsName() {
		Event event = new Event();
		Event event2 = new Event();
		event.setName("ANOTHERTESTEVENT");

		assertNotEquals(event, event2);
	}
	
	@Test
	public void equalsSummary() {
		Event event = new Event();
		event.setSummary("TESTSAMMANFATTNING");
		Event event2 = new Event();
		event2.setSummary("TESTSAMMANFATTNING");

		assertEquals(event, event2);
	}
	
	@Test
	public void notEqualsSummary() {
		Event event = new Event();
		Event event2 = new Event();
		event.setSummary("TESTSAMMANFATTNING");

		assertNotEquals(event, event2);
	}
	
	@Test
	public void equalsStartTime() {
		LocalDateTime now = LocalDateTime.now();
		
		Event event = new Event();
		event.setStartTime(now);
		Event event2 = new Event();
		event2.setStartTime(now);

		assertEquals(event, event2);
	}
	
	@Test
	public void notEqualsStartTime() {
		LocalDateTime now = LocalDateTime.now();
		
		Event event = new Event();
		Event event2 = new Event();
		event2.setStartTime(now);

		assertNotEquals(event, event2);
	}
	
	@Test
	public void equalsEndTime() {
		LocalDateTime now = LocalDateTime.now();
		
		Event event = new Event();
		event.setEndTime(now);
		Event event2 = new Event();
		event2.setEndTime(now);

		assertEquals(event, event2);
	}
	
	@Test
	public void notEqualsEndTime() {
		LocalDateTime now = LocalDateTime.now();
		
		Event event = new Event();
		Event event2 = new Event();
		event2.setEndTime(now);

		assertNotEquals(event, event2);
	}
	
	@Test
	public void equalsHashCode() {
		Event event = new Event();
		Event event2 = new Event();
		
		assertEquals(event.hashCode(), event2.hashCode());
	}
	
	@Test
	public void notEqualsHashCode() {
		Event event = new Event();
		Event event2 = new Event();
		event2.setId(Long.MAX_VALUE);
		
		assertNotEquals(event.hashCode(), event2.hashCode());
	}
	
}

