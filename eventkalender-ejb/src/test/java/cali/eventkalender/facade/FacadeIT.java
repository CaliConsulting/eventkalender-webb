package cali.eventkalender.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;
import cali.eventkalender.test.Deployments;
import cali.eventkalender.test.Deployments.ArchiveType;

@RunWith(Arquillian.class)
public class FacadeIT {

    @EJB
    private FacadeLocal facade;
    
    @Deployment
    public static Archive<?> createArchive() {
        return Deployments.getArchive(ArchiveType.EAO);
    }
    
    @Test
    public void addEvent() {
        Nation nation = new Nation("TESTNATION");
        
        LocalDateTime now = LocalDateTime.now();
        Event event = new Event("TESTEVENT", "TESTSAMMANFATTNING", now, now);
        event.setNation(nation);
        
        facade.addEvent(event);
        
        Event fetchedEvent = facade.findEventById(event.getId());
        
        assertNotNull(fetchedEvent);
        assertEquals("TESTEVENT", fetchedEvent.getName());
        assertEquals("TESTSAMMANFATTNING", fetchedEvent.getSummary());
        assertEquals(now, fetchedEvent.getStartTime());
        assertEquals(now, fetchedEvent.getEndTime());
        assertEquals(nation, event.getNation());
    }
    
}
