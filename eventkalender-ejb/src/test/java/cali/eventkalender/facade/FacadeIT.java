package cali.eventkalender.facade;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;
import cali.eventkalender.model.Person;
import cali.eventkalender.test.Deployments;
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
        
        expectedEventId = Long.MIN_VALUE;
        expectedEventName = "TESTEVENT";
        expectedEventSummary = "TESTSAMMANFATTNING";
        expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
        expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
        expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime, expectedEventEndTime);
        expectedEvent.setId(expectedEventId);
        expectedEvent.setNation(expectedNation);
        
        expectedPersonId = Long.MAX_VALUE;
        expectedPersonFirstName = "FÖRNAMN";
        expectedPersonLastName = "EFTERNAMN";
        expectedPerson = new Person(expectedPersonFirstName, expectedPersonLastName);
        expectedPerson.setId(expectedPersonId);
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
    
}
