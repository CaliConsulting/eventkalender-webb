package cali.eventkalender.utility;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Person;

@RunWith(JUnit4.class)
public class MessageUtilityTest {

	private int personsCap;
	private int eventsCap;

	private Person p1;
	private Person p2;
	private Person p3;
	private Person p4;

	private List<Person> persons;

	private Event e1;
	private Event e2;
	private Event e3;
	private Event e4;

	private List<Event> events;

	@Before
	public void setup() {
		personsCap = 3;
		eventsCap = 3;

		p1 = new Person("P1FirstName", "P1LastName");
		p2 = new Person("P2FirstName", "P2LastName");
		p3 = new Person("P3FirstName", "P3LastName");
		p4 = new Person("P4FirstName", "P4LastName");

		persons = new ArrayList<>();

		e1 = new Event("E1Name", "", LocalDateTime.now(), LocalDateTime.now());
		e2 = new Event("E2Name", "", LocalDateTime.now(), LocalDateTime.now());
		e3 = new Event("E3Name", "", LocalDateTime.now(), LocalDateTime.now());
		e4 = new Event("E4Name", "", LocalDateTime.now(), LocalDateTime.now());

		events = new ArrayList<>();
	}

	@Test
	public void getPersonsInvitationMessageNone() {
		String expectedMessage = "inga personer";
		String actualMessage = MessageUtility.getPersonsInvitationMessage(persons, personsCap);

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getPersonsInvitationMessageSingle() {
		persons.add(p1);

		String expectedMessage = "personen P1FirstName P1LastName";
		String actualMessage = MessageUtility.getPersonsInvitationMessage(persons, personsCap);

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getPersonsInvitationMessageBelowCap() {
		persons.add(p1);
		persons.add(p2);

		String expectedMessage = "personerna P1FirstName P1LastName och P2FirstName P2LastName";
		String actualMessage = MessageUtility.getPersonsInvitationMessage(persons, personsCap);

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getPersonsInvitationMessageBelowCapWithComma() {
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);

		String expectedMessage = "personerna P1FirstName P1LastName, P2FirstName P2LastName och P3FirstName P3LastName";
		String actualMessage = MessageUtility.getPersonsInvitationMessage(persons, personsCap);

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getPersonsInvitationMessageAboveCap() {
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);

		String expectedMessage = "4 personer";
		String actualMessage = MessageUtility.getPersonsInvitationMessage(persons, personsCap);

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getEventsInvitationMessageNone() {
		String expectedMessage = "inga evenemang";
		String actualMessage = MessageUtility.getEventsInvitationMessage(events, eventsCap);

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getEventsInvitationMessageSingle() {
		events.add(e1);

		String expectedMessage = "evenemanget E1Name";
		String actualMessage = MessageUtility.getEventsInvitationMessage(events, eventsCap);

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getEventsInvitationMessageBelowCap() {
		events.add(e1);
		events.add(e2);

		String expectedMessage = "evenemangen E1Name och E2Name";
		String actualMessage = MessageUtility.getEventsInvitationMessage(events, eventsCap);

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getEventsInvitationMessageBelowCapWithComma() {
		events.add(e1);
		events.add(e2);
		events.add(e3);

		String expectedMessage = "evenemangen E1Name, E2Name och E3Name";
		String actualMessage = MessageUtility.getEventsInvitationMessage(events, eventsCap);

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	public void getEventsInvitationMessageAboveCap() {
		events.add(e1);
		events.add(e2);
		events.add(e3);
		events.add(e4);

		String expectedMessage = "4 evenemang";
		String actualMessage = MessageUtility.getEventsInvitationMessage(events, eventsCap);

		assertEquals(expectedMessage, actualMessage);
	}

}
