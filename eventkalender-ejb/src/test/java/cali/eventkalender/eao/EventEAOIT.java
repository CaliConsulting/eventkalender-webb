package cali.eventkalender.eao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
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
    
    private String expectedEventName;
    private String expectedEventSummary;
    private LocalDateTime expectedEventStartTime;
    private LocalDateTime expectedEventEndTime;
    
    private Event expectedEvent;
    
    private String expectedNationName;
    
    private Nation expectedNation;

    @EJB
    private EventEAOLocal eventEAO;

    @Deployment
    public static Archive<?> createArchive() {
        return Deployments.getArchive(ArchiveType.EAO);
    }

    @Before
    public void setup() {
        expectedNationName = "TESTNATION";
        expectedNation = new Nation(expectedNationName);

        expectedEventName = "TESTEVENT";
        expectedEventSummary = "TESTSAMMANFATTNING";
        expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
        expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
        expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime, expectedEventEndTime);
        expectedEvent.setNation(expectedNation);
    }

    @Test
    public void add() {
        eventEAO.add(expectedEvent);

        Event fetchedEvent = eventEAO.findById(expectedEvent.getId());

        assertNotNull(fetchedEvent);
        assertEquals(expectedEventName, fetchedEvent.getName());
        assertEquals(expectedEventSummary, fetchedEvent.getSummary());
        assertEquals(expectedEventStartTime, fetchedEvent.getStartTime());
        assertEquals(expectedEventEndTime, fetchedEvent.getEndTime());
        assertEquals(expectedNation, fetchedEvent.getNation());
    }

    @Test
    public void delete() {
        eventEAO.add(expectedEvent);

        long id = expectedEvent.getId();
        eventEAO.delete(id);

        Event fetchedEvent = eventEAO.findById(id);

        assertNull(fetchedEvent);
    }

    @Test
    public void update() {
        eventEAO.add(expectedEvent);

        LocalDateTime updateTime = LocalDateTime.of(2010, 1, 1, 12, 0);
        expectedEvent.setName("UPDATEEVENT");
        expectedEvent.setSummary("UPDATESAMMANFATTNING");
        expectedEvent.setStartTime(updateTime);
        expectedEvent.setEndTime(updateTime);
        eventEAO.update(expectedEvent);

        assertEquals("UPDATEEVENT", expectedEvent.getName());
        assertEquals("UPDATESAMMANFATTNING", expectedEvent.getSummary());
        assertEquals(updateTime, expectedEvent.getStartTime());
        assertEquals(updateTime, expectedEvent.getEndTime());
    }

}
