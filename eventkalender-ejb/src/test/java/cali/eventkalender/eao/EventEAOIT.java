package cali.eventkalender.eao;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;
import cali.eventkalender.test.Deployments;
import cali.eventkalender.test.Deployments.ArchiveType;

@RunWith(Arquillian.class)
public class EventEAOIT {

	@EJB
	private EventEAOLocal eventEAO;
	
	@Deployment
	public static Archive<?> createArchive() {
	    return Deployments.getArchive(ArchiveType.EAO);
	}

	@Test
	public void add() {
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
