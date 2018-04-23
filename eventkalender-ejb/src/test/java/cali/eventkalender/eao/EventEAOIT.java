package cali.eventkalender.eao;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
		assertEquals(nation, fetchedEvent.getNation());
	}
	
    @Test
    public void delete() {
        Nation nation = new Nation("TESTNATION");

        LocalDateTime now = LocalDateTime.now();
        Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", now, now);
        event.setNation(nation);

        eventEAO.add(event);
        
        long id = event.getId();
        eventEAO.delete(id);

        Event fetchedEvent = eventEAO.findById(id);
        
        assertNull(fetchedEvent);
    }
    
    @Test
    public void update() {
        Nation nation = new Nation("TESTNATION");

        LocalDateTime now = LocalDateTime.now();
        Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", now, now);
        event.setNation(nation);

        eventEAO.add(event);
        
        LocalDateTime updateTime = LocalDateTime.now();
        event.setName("UPDATEEVENT");
        event.setSummary("UPDATESAMMANFATTNING");
        event.setStartTime(updateTime);
        event.setEndTime(updateTime);
        eventEAO.update(event);
        
        assertEquals("UPDATEEVENT", event.getName());
        assertEquals("UPDATESAMMANFATTNING", event.getSummary());
        assertEquals(updateTime, event.getStartTime());
        assertEquals(updateTime, event.getEndTime());
    }

}
