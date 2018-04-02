package cali.eventkalender.eao;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;

@RunWith(Arquillian.class)
public class EventEAOIT {

	@EJB
	private EventEAOLocal eventEAO;
	
	@Deployment
	public static JavaArchive createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "eventeao-it.jar").addClasses(Event.class, EventEAO.class)
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
	}

	@Test
	public void addEvent() {
		Nation nation = new Nation("TESTNATION");
		
		LocalDateTime now = LocalDateTime.now();
		Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", now, now);
		event.setNation(nation);

		eventEAO.add(event);

		Event fetchedEvent = eventEAO.findById(event.getId());

		assertNotNull(fetchedEvent);
		assertEquals("TESTEVENT", fetchedEvent.getName());
		assertEquals("TESTSAMMANFATTNING", fetchedEvent.getSummary());
		assertEquals(now, fetchedEvent.getStartTime());
		assertEquals(now, fetchedEvent.getEndTime());
		assertEquals(nation, event.getNation());
	}

}
