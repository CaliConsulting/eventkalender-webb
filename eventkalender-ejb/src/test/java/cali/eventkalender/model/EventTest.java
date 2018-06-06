package cali.eventkalender.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EventTest {

	private Event expectedEventDefault;

	private Long expectedEventId;
	private String expectedEventName;
	private String expectedEventSummary;
	private LocalDateTime expectedEventStartTime;
	private LocalDateTime expectedEventEndTime;

	private Event expectedEventOverloaded;
	private Event expectedEventOverloaded2;
	private Event expectedEventRelations;

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

		expectedEventDefault = new Event();

		expectedEventId = Long.MIN_VALUE;
		expectedEventName = "TESTEVENT";
		expectedEventSummary = "TESTSAMMANFATTNING";
		expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
		expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
		expectedEventOverloaded = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime,
				expectedEventEndTime);
		expectedEventOverloaded.setId(expectedEventId);
		expectedEventOverloaded.setNation(expectedNation);

		expectedPersonId = Long.MAX_VALUE;
		expectedPersonFirstName = "FÖRNAMN";
		expectedPersonLastName = "EFTERNAMN";
		expectedPerson = new Person(expectedPersonFirstName, expectedPersonLastName);
		expectedPerson.setId(expectedPersonId);

		// Copy event to use in equals test
		expectedEventOverloaded2 = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime,
				expectedEventEndTime);
		expectedEventOverloaded.setId(expectedEventId);
		expectedEventOverloaded.setNation(expectedNation);

		// Use for relation test
		expectedEventRelations = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime,
				expectedEventEndTime, expectedNation, Arrays.asList(expectedPerson));
		expectedEventRelations.setId(expectedEventId);
	}

	@Test
	public void constructorDefault() {
		assertEquals(Long.valueOf(Long.MIN_VALUE), expectedEventDefault.getId());
		assertNull(expectedEventDefault.getName());
		assertNull(expectedEventDefault.getSummary());
		assertNull(expectedEventDefault.getStartTime());
		assertNull(expectedEventDefault.getEndTime());
		assertNull(expectedEventDefault.getNation());
		assertEquals(0, expectedEventDefault.getPersons().size());
	}

	@Test
	public void constructorValues() {
		assertEquals(expectedEventId, expectedEventOverloaded.getId());
		assertEquals(expectedEventName, expectedEventOverloaded.getName());
		assertEquals(expectedEventSummary, expectedEventOverloaded.getSummary());
		assertEquals(expectedEventStartTime, expectedEventOverloaded.getStartTime());
		assertEquals(expectedEventEndTime, expectedEventOverloaded.getEndTime());
	}

	@Test
	public void constructorRelations() {
		assertEquals(expectedEventId, expectedEventOverloaded.getId());
		assertEquals(expectedEventName, expectedEventRelations.getName());
		assertEquals(expectedEventSummary, expectedEventRelations.getSummary());
		assertEquals(expectedEventStartTime, expectedEventRelations.getStartTime());
		assertEquals(expectedEventEndTime, expectedEventRelations.getEndTime());
		assertEquals(expectedNation, expectedEventRelations.getNation());
		assertEquals(1, expectedEventRelations.getPersons().size());
	}

	@Test
	public void getId() {
		assertEquals(expectedEventId, expectedEventOverloaded.getId());
	}

	@Test
	public void setId() {
		expectedEventOverloaded.setId(Long.MAX_VALUE);
		assertEquals(Long.valueOf(Long.MAX_VALUE), expectedEventOverloaded.getId());
	}

	@Test
	public void getName() {
		assertEquals(expectedEventName, expectedEventOverloaded.getName());
	}

	@Test
	public void setName() {
		expectedEventOverloaded.setName("SETTESTEVENT");
		assertEquals("SETTESTEVENT", expectedEventOverloaded.getName());
	}

	@Test
	public void getSummary() {
		assertEquals(expectedEventSummary, expectedEventOverloaded.getSummary());
	}

	@Test
	public void setSummary() {
		expectedEventOverloaded.setSummary("SETTESTSAMMANFATTNING");
		assertEquals("SETTESTSAMMANFATTNING", expectedEventOverloaded.getSummary());
	}

	@Test
	public void getStartTime() {
		assertEquals(expectedEventStartTime, expectedEventOverloaded.getStartTime());
	}

	@Test
	public void getStartTimeFormatted() {
		assertEquals("2000-01-01 12:00", expectedEventOverloaded.getStartTimeFormatted());
	}

	@Test
	public void setStartTime() {
		LocalDateTime startTime = LocalDateTime.of(2010, 1, 1, 12, 00);
		expectedEventOverloaded.setStartTime(startTime);
		assertEquals(startTime, expectedEventOverloaded.getStartTime());
	}

	@Test
	public void getEndTime() {
		assertEquals(expectedEventEndTime, expectedEventOverloaded.getEndTime());
	}

	@Test
	public void getEndTimeFormatted() {
		assertEquals("2000-01-01 14:00", expectedEventOverloaded.getEndTimeFormatted());
	}

	@Test
	public void setEndTime() {
		assertEquals(expectedEventEndTime, expectedEventOverloaded.getEndTime());
	}

	@Test
	public void equals() {
		Event event = new Event(expectedEventOverloaded.getName(), expectedEventOverloaded.getSummary(),
				expectedEventOverloaded.getStartTime(), expectedEventOverloaded.getEndTime());
		event.setId(expectedEventOverloaded.getId());
		assertEquals(expectedEventOverloaded, event);
	}

	@Test
	public void equalsItself() {
		assertEquals(expectedEventOverloaded, expectedEventOverloaded);
	}

	@Test
	public void equalsOtherInstanceWithValues() {
		assertEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void notEqualsNull() {
		assertNotEquals(null, expectedEventOverloaded);
	}

	@Test
	public void notEqualsNullParameter() {
		assertFalse(expectedEventOverloaded.equals(null));
	}

	@Test
	public void notEqualsIncompatibleObject() {
		assertNotEquals(new Object(), expectedEventOverloaded);
	}

	@Test
	public void notEqualsIncompatibleObjectParameter() {
		assertFalse(expectedEventOverloaded.equals(new Object()));
	}

	@Test
	public void equalsId() {
		assertEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void notEqualsId() {
		expectedEventOverloaded2.setId(Long.MAX_VALUE);
		assertNotEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void equalsName() {
		assertEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void notEqualsName() {
		expectedEventOverloaded2.setName("ANOTHERTESTEVENT");
		assertNotEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void equalsSummary() {
		assertEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void notEqualsSummary() {
		expectedEventOverloaded2.setSummary("ANOTHERTESTSAMMANFATTNING");
		assertNotEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void equalsStartTime() {
		assertEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void notEqualsStartTime() {
		expectedEventOverloaded2.setStartTime(LocalDateTime.now());
		assertNotEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void equalsEndTime() {
		assertEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void notEqualsEndTime() {
		expectedEventOverloaded2.setEndTime(LocalDateTime.now());
		assertNotEquals(expectedEventOverloaded, expectedEventOverloaded2);
	}

	@Test
	public void equalsHashCode() {
		assertEquals(expectedEventOverloaded.hashCode(), expectedEventOverloaded2.hashCode());
	}

	@Test
	public void notEqualsHashCode() {
		expectedEventOverloaded2.setId(Long.MAX_VALUE);
		assertNotEquals(expectedEventOverloaded.hashCode(), expectedEventOverloaded2.hashCode());
	}

}
