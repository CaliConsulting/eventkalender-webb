package cali.eventkalender.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;
import cali.eventkalender.model.Person;
import cali.eventkalender.test.Deployments;
import cali.eventkalender.test.PersistenceManagerLocal;
import cali.eventkalender.test.Deployments.ArchiveType;

@RunWith(Arquillian.class)
public class FacadeIT {

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

	@EJB
	private FacadeLocal facade;

	@EJB
	private PersistenceManagerLocal persistenceManager;

	@Deployment
	public static Archive<?> createArchive() {
		return Deployments.getArchive(ArchiveType.EAO);
	}

	@Before
	public void setup() {
		expectedNationId = -1L;
		expectedNationName = "TESTNATION";
		expectedNation = new Nation(expectedNationName);
		expectedNation.setId(expectedNationId);

		expectedEventId = -10L;
		expectedEventName = "TESTEVENT";
		expectedEventSummary = "TESTSUMMARY";
		expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
		expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
		expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime,
				expectedEventEndTime);
		expectedEvent.setId(expectedEventId);
		expectedEvent.setNation(expectedNation);

		expectedPersonId = -100L;
		expectedPersonFirstName = "FIRSTNAME";
		expectedPersonLastName = "LASTNAME";
		expectedPerson = new Person(expectedPersonFirstName, expectedPersonLastName);
		expectedPerson.setId(expectedPersonId);
	}

	@After
	public void teardown() {
		persistenceManager.cleanDatabase();
	}

	@Test
	public void addEvent() {
		facade.addEvent(expectedEvent);

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());

		assertNotNull(fetchedEvent);
		assertEquals(expectedEventName, fetchedEvent.getName());
		assertEquals(expectedEventSummary, fetchedEvent.getSummary());
		assertEquals(expectedEventStartTime, fetchedEvent.getStartTime());
		assertEquals(expectedEventEndTime, fetchedEvent.getEndTime());
		assertEquals(expectedNation, expectedEvent.getNation());
	}

	@Test
	public void addEventWithExistingNation() {
		facade.addNation(expectedNation);
		expectedEvent.setNation(expectedNation);
		facade.addEvent(expectedEvent);

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());

		assertNotNull(fetchedEvent);
		assertEquals(expectedEventName, fetchedEvent.getName());
		assertEquals(expectedEventSummary, fetchedEvent.getSummary());
		assertEquals(expectedEventStartTime, fetchedEvent.getStartTime());
		assertEquals(expectedEventEndTime, fetchedEvent.getEndTime());
		assertEquals(expectedNation, expectedEvent.getNation());

		Nation fetchedNation = facade.findNationById(expectedNation.getId());

		assertNotNull(fetchedNation);
	}

	@Test
	public void addEventWithExistingPerson() {
		facade.addPerson(expectedPerson);
		expectedEvent.addPerson(expectedPerson);
		facade.addEvent(expectedEvent);

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());

		assertNotNull(fetchedEvent);
		assertEquals(expectedEventName, fetchedEvent.getName());
		assertEquals(expectedEventSummary, fetchedEvent.getSummary());
		assertEquals(expectedEventStartTime, fetchedEvent.getStartTime());
		assertEquals(expectedEventEndTime, fetchedEvent.getEndTime());
		assertEquals(expectedNation, expectedEvent.getNation());

		Person fetchedPerson = facade.findPersonById(expectedPerson.getId());

		assertNotNull(fetchedPerson);
	}

	@Test
	public void addEventWithNonExistingPerson() {
		expectedEvent.addPerson(expectedPerson);
		facade.addEvent(expectedEvent);

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());

		assertNotNull(fetchedEvent);
		assertEquals(expectedEventName, fetchedEvent.getName());
		assertEquals(expectedEventSummary, fetchedEvent.getSummary());
		assertEquals(expectedEventStartTime, fetchedEvent.getStartTime());
		assertEquals(expectedEventEndTime, fetchedEvent.getEndTime());
		assertEquals(expectedNation, expectedEvent.getNation());

		Person fetchedPerson = facade.findPersonById(expectedPerson.getId());

		assertNotNull(fetchedPerson);
	}

	@Test
	public void addNation() {
		facade.addNation(expectedNation);

		Nation fetchedNation = facade.findNationById(expectedNation.getId());

		assertNotNull(fetchedNation);
		assertEquals(expectedNationName, fetchedNation.getName());
	}

	@Test
	public void addNationWithExistingEvent() {
		facade.addEvent(expectedEvent);
		expectedNation.addEvent(expectedEvent);
		facade.addNation(expectedNation);

		Nation fetchedNation = facade.findNationById(expectedNation.getId());

		assertNotNull(fetchedNation);
		assertEquals(expectedNationName, fetchedNation.getName());

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());

		assertNotNull(fetchedEvent);
	}

	@Test
	public void addPerson() {
		facade.addPerson(expectedPerson);

		Person fetchedPerson = facade.findPersonById(expectedPerson.getId());

		assertNotNull(fetchedPerson);
		assertEquals(expectedPersonFirstName, fetchedPerson.getFirstName());
		assertEquals(expectedPersonLastName, fetchedPerson.getLastName());
	}

	@Test
	public void addPersonWithExistingEvent() {
		facade.addEvent(expectedEvent);
		expectedPerson.addEvent(expectedEvent);
		facade.addPerson(expectedPerson);

		Person fetchedPerson = facade.findPersonById(expectedPerson.getId());

		assertNotNull(fetchedPerson);
		assertEquals(expectedPersonFirstName, fetchedPerson.getFirstName());
		assertEquals(expectedPersonLastName, fetchedPerson.getLastName());

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());

		assertNotNull(fetchedEvent);
	}

	@Test
	public void addPersonWithNonExistingEvent() {
		Nation tempNation = new Nation("TEMPNATION");
		facade.addNation(tempNation);

		expectedEvent.setNation(tempNation);

		expectedPerson.addEvent(expectedEvent);
		facade.addPerson(expectedPerson);

		Person fetchedPerson = facade.findPersonById(expectedPerson.getId());

		assertNotNull(fetchedPerson);
		assertEquals(expectedPersonFirstName, fetchedPerson.getFirstName());
		assertEquals(expectedPersonLastName, fetchedPerson.getLastName());

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());

		assertNotNull(fetchedEvent);
	}

	@Test
	public void deleteEvent() {
		facade.addEvent(expectedEvent);
		facade.deleteEvent(expectedEvent.getId());

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());
		assertNull(fetchedEvent);
	}

	@Test
	public void deleteNation() {
		facade.addNation(expectedNation);
		facade.deleteNation(expectedNation.getId());

		Nation fetchedNation = facade.findNationById(expectedNation.getId());
		assertNull(fetchedNation);
	}

	@Test
	public void deletePerson() {
		facade.addPerson(expectedPerson);
		facade.deletePerson(expectedPerson.getId());

		Person fetchedPerson = facade.findPersonById(expectedPerson.getId());
		assertNull(fetchedPerson);
	}

	@Test
	public void findAllEvents() {
		facade.addEvent(expectedEvent);
		List<Event> events = facade.findAllEvents();

		assertTrue(events.contains(expectedEvent));
	}

	@Test
	public void findAllNations() {
		facade.addNation(expectedNation);
		List<Nation> nations = facade.findAllNations();

		assertTrue(nations.contains(expectedNation));
	}

	@Test
	public void findAllPersons() {
		facade.addPerson(expectedPerson);
		List<Person> persons = facade.findAllPersons();

		assertTrue(persons.contains(expectedPerson));
	}

	@Test
	public void findEventById() {
		facade.addEvent(expectedEvent);
		Event fetchedEvent = facade.findEventById(expectedEvent.getId());

		assertNotNull(fetchedEvent);
		assertEquals(expectedEventName, fetchedEvent.getName());
		assertEquals(expectedEventSummary, fetchedEvent.getSummary());
		assertEquals(expectedEventStartTime, fetchedEvent.getStartTime());
		assertEquals(expectedEventEndTime, fetchedEvent.getEndTime());
		assertEquals(expectedNation, expectedEvent.getNation());
	}

	@Test
	public void findNationById() {
		facade.addNation(expectedNation);
		Nation fetchedNation = facade.findNationById(expectedNation.getId());

		assertNotNull(fetchedNation);
		assertEquals(expectedNationName, fetchedNation.getName());
	}

	@Test
	public void findPersonById() {
		facade.addPerson(expectedPerson);
		Person fetchedPerson = facade.findPersonById(expectedPerson.getId());

		assertNotNull(fetchedPerson);
		assertEquals(expectedPersonFirstName, fetchedPerson.getFirstName());
		assertEquals(expectedPersonLastName, fetchedPerson.getLastName());
	}

	@Test
	public void updateEvent() {
		facade.addEvent(expectedEvent);

		expectedEvent.setName("PHILIP");
		facade.updateEvent(expectedEvent);

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());
		assertEquals("PHILIP", fetchedEvent.getName());
	}

	@Test
	public void updateEventAndPersonWithRelation() {
		facade.addEvent(expectedEvent);
		facade.addPerson(expectedPerson);

		expectedEvent.addPerson(expectedPerson);
		expectedPerson.addEvent(expectedEvent);

		facade.updateEvent(expectedEvent);
		facade.updatePerson(expectedPerson);

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());
		Person fetchedPerson = facade.findPersonById(expectedPerson.getId());

		assertNotNull(fetchedEvent);
		assertTrue(fetchedEvent.getPersons().contains(fetchedPerson));
		assertEquals(1, fetchedEvent.getPersons().size());

		assertNotNull(fetchedPerson);
		assertTrue(fetchedPerson.getEvents().contains(fetchedEvent));
		assertEquals(1, fetchedPerson.getEvents().size());
	}

	@Test
	public void updateNation() {
		facade.addNation(expectedNation);

		expectedNation.setName("PHILIP");
		facade.updateNation(expectedNation);

		Nation fetchedNation = facade.findNationById(expectedNation.getId());
		assertEquals("PHILIP", fetchedNation.getName());
	}

	@Test
	public void updateNationAndEventWithRelation() {
		facade.addEvent(expectedEvent);
		facade.addNation(expectedNation);

		expectedEvent.addPerson(expectedPerson);
		expectedNation.addEvent(expectedEvent);

		facade.updateEvent(expectedEvent);
		facade.updateNation(expectedNation);

		Event fetchedEvent = facade.findEventById(expectedEvent.getId());
		Nation fetchedNation = facade.findNationById(expectedNation.getId());

		assertNotNull(fetchedEvent);
		assertTrue(fetchedEvent.getNation().equals(fetchedNation));

		assertNotNull(fetchedNation);
		assertTrue(fetchedNation.getEvents().contains(fetchedEvent));
		assertEquals(1, fetchedNation.getEvents().size());
	}

	@Test
	public void updatePerson() {
		facade.addPerson(expectedPerson);

		expectedPerson.setFirstName("PHILIP");
		facade.updatePerson(expectedPerson);

		Person fetchedPerson = facade.findPersonById(expectedPerson.getId());
		assertEquals("PHILIP", fetchedPerson.getFirstName());
	}
}
