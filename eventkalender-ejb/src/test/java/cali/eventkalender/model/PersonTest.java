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
public class PersonTest {

	private Person expectedPersonDefault;

	private Long expectedPersonId;
	private String expectedPersonFirstName;
	private String expectedPersonLastName;

	private Person expectedPersonOverloaded;
	private Person expectedPersonOverloaded2;
	private Person expectedPersonRelations;

	private Long expectedEventId;
	private String expectedEventName;
	private String expectedEventSummary;
	private LocalDateTime expectedEventStartTime;
	private LocalDateTime expectedEventEndTime;

	private Event expectedEvent;

	private Long expectedNationId;
	private String expectedNationName;

	@Before
	public void setup() {
		expectedPersonDefault = new Person();

		expectedPersonId = -1L;
		expectedPersonFirstName = "TESTPERSONFIRSTNAME";
		expectedPersonLastName = "TESTPERSONLASTNAME";
		expectedPersonOverloaded = new Person(expectedPersonFirstName, expectedPersonLastName);
		expectedPersonOverloaded.setId(expectedPersonId);

		expectedEventId = Long.MIN_VALUE;
		expectedEventName = "TESTEVENT";
		expectedEventSummary = "TESTSAMMANFATTNING";
		expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
		expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
		expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime,
				expectedEventEndTime);
		expectedEvent.setId(expectedEventId);

		// Copy nation to use in equals test
		expectedPersonOverloaded2 = new Person(expectedPersonFirstName, expectedPersonLastName);
		expectedPersonOverloaded2.setId(expectedPersonId);

		// Use for relation test
		expectedPersonRelations = new Person(expectedPersonFirstName, expectedPersonLastName,
				Arrays.asList(expectedEvent));
		expectedPersonRelations.setId(expectedPersonId);
	}

	@Test
	public void constructorDefault() {
		assertEquals(Long.valueOf(Long.MIN_VALUE), expectedPersonDefault.getId());
		assertNull(expectedPersonDefault.getFirstName());
		assertNull(expectedPersonDefault.getLastName());
		assertEquals(0, expectedPersonDefault.getEvents().size());
	}

	@Test
	public void constructorValues() {
		assertEquals(expectedPersonId, expectedPersonOverloaded.getId());
		assertEquals(expectedPersonFirstName, expectedPersonOverloaded.getFirstName());
		assertEquals(expectedPersonLastName, expectedPersonOverloaded.getLastName());
	}

	@Test
	public void constructorRelations() {
		assertEquals(expectedPersonId, expectedPersonOverloaded.getId());
		assertEquals(expectedPersonFirstName, expectedPersonOverloaded.getFirstName());
		assertEquals(expectedPersonLastName, expectedPersonOverloaded.getLastName());
		assertEquals(1, expectedPersonRelations.getEvents().size());
	}

	@Test
	public void getId() {
		assertEquals(expectedPersonId, expectedPersonOverloaded.getId());
	}

	@Test
	public void setId() {
		expectedPersonOverloaded.setId(Long.MAX_VALUE);
		assertEquals(Long.valueOf(Long.MAX_VALUE), expectedPersonOverloaded.getId());
	}

	@Test
	public void getFirstName() {
		assertEquals(expectedPersonFirstName, expectedPersonOverloaded.getFirstName());
	}

	@Test
	public void getLastName() {
		assertEquals(expectedPersonLastName, expectedPersonOverloaded.getLastName());
	}

	@Test
	public void setFirstName() {
		expectedPersonOverloaded.setFirstName("ANOTHERTESTPERSONFIRSTNAME");
		assertEquals("ANOTHERTESTPERSONFIRSTNAME", expectedPersonOverloaded.getFirstName());
	}

	@Test
	public void setLastName() {
		expectedPersonOverloaded.setLastName("ANOTHERTESTPERSONLASTNAME");
		assertEquals("ANOTHERTESTPERSONLASTNAME", expectedPersonOverloaded.getLastName());
	}

	@Test
	public void equals() {
		Person person = new Person(expectedPersonFirstName, expectedPersonLastName);
		person.setId(expectedPersonId);
		assertEquals(person, expectedPersonOverloaded);
	}

	@Test
	public void equalsItself() {
		assertEquals(expectedPersonOverloaded, expectedPersonOverloaded);
	}

	@Test
	public void equalsOtherInstanceWithValues() {
		assertEquals(expectedPersonOverloaded, expectedPersonOverloaded2);
	}

	@Test
	public void notEqualsNull() {
		assertNotEquals(null, expectedPersonOverloaded);
	}

	@Test
	public void notEqualsNullParameter() {
		assertFalse(expectedPersonOverloaded.equals(null));
	}

	@Test
	public void notEqualsIncompatibleObject() {
		assertNotEquals(new Object(), expectedPersonOverloaded);
	}

	@Test
	public void notEqualsIncompatibleObjectParameter() {
		assertFalse(expectedPersonOverloaded.equals(new Object()));
	}

	@Test
	public void equalsId() {
		assertEquals(expectedPersonOverloaded, expectedPersonOverloaded2);
	}

	@Test
	public void notEqualsId() {
		expectedPersonOverloaded2.setId(Long.MAX_VALUE);
		assertNotEquals(expectedPersonOverloaded, expectedPersonOverloaded2);
	}

	@Test
	public void equalsName() {
		assertEquals(expectedPersonOverloaded, expectedPersonOverloaded2);
	}

	@Test
	public void notEqualsFirstName() {
		expectedPersonOverloaded2.setFirstName("ANOTHERTESTPERSONFIRSTNAME");
		assertNotEquals(expectedPersonOverloaded, expectedPersonOverloaded2);
	}

	@Test
	public void notEqualsLastName() {
		expectedPersonOverloaded2.setLastName("ANOTHERTESTPERSONLASTNAME");
		assertNotEquals(expectedPersonOverloaded, expectedPersonOverloaded2);
	}

	@Test
	public void equalsHashCode() {
		assertEquals(expectedPersonOverloaded.hashCode(), expectedPersonOverloaded.hashCode());
	}

	@Test
	public void notEqualsHashCode() {
		expectedPersonOverloaded2.setId(Long.MAX_VALUE);
		assertNotEquals(expectedPersonOverloaded.hashCode(), expectedPersonOverloaded2.hashCode());
	}

}
