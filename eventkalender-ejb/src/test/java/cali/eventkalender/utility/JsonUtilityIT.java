package cali.eventkalender.utility;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;
import cali.eventkalender.model.Person;

@RunWith(JUnit4.class)
public class JsonUtilityIT {
	
    private Long expectedEventId;
    private String expectedEventName;
    private String expectedEventSummary;
    private LocalDateTime expectedEventStartTime;
    private LocalDateTime expectedEventEndTime;
    
    private Event expectedEvent;
    private Nation expectedNation;
    

	@Test
	public void toCalendarJsonEmpty() {
		String expectedJson = "[]";
		
		List<Event> events = new ArrayList<>();
		
		assertEquals(expectedJson, JsonUtility.toCalendarJson(events));
	}
	
	@Test
	public void toCalendarJsonEvent() {
        expectedEventId = Long.MIN_VALUE;
        expectedEventName = "TESTEVENT";
        expectedEventSummary = "TESTSAMMANFATTNING";
        expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
        expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
        expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime, expectedEventEndTime);
        expectedEvent.setId(expectedEventId);
        expectedEvent.setNation(expectedNation);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        List<Event> events = Arrays.asList(expectedEvent);
        StringBuilder b = new StringBuilder();
        b.append("[{\"title\":\"" + expectedEvent.getName());
        b.append("\",\"start\":\"" + expectedEvent.getStartTime().format(formatter));
        b.append("\",\"end\":\"" + expectedEvent.getEndTime().format(formatter));
        b.append("\"}]");

        assertEquals(b.toString(), JsonUtility.toCalendarJson(events));
	}
	
	@Test
	public void toJsonNation() {
		Nation testNation = new Nation("TestNation");
		StringBuilder b = new StringBuilder();
		b.append("{\"id\":");
		b.append(testNation.getId() + ",");
		b.append("\"name\":\"" + testNation.getName());
		b.append("\"}");
		assertEquals(b.toString(), JsonUtility.toJson(testNation));
	}
	
	@Test
	public void toJsonPerson() {
		Person testPerson = new Person("Test","Person");
		StringBuilder b = new StringBuilder();
		b.append("{\"id\":");
		b.append(testPerson.getId() + ",");
		b.append("\"firstName\":\"" + testPerson.getFirstName());
		b.append("\",\"lastName\":\"" + testPerson.getLastName());
		b.append("\"}");
		assertEquals(b.toString(), JsonUtility.toJson(testPerson));
	}
	
	@Test
	public void toJsonEvent() {
        expectedEventId = Long.MIN_VALUE;
        expectedEventName = "TESTEVENT";
        expectedEventSummary = "TESTSAMMANFATTNING";
        expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
        expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
        expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime, expectedEventEndTime);
        expectedEvent.setId(expectedEventId);
        expectedEvent.setNation(expectedNation);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        
        StringBuilder b = new StringBuilder();
        b.append("{\"id\":");
        b.append(expectedEvent.getId() + ",");
        b.append("\"name\":\"" + expectedEvent.getName());
        b.append("\",\"summary\":\"" + expectedEvent.getSummary());
        b.append("\",\"startTime\":\"" + expectedEvent.getStartTime().format(formatter));
        b.append("\",\"endTime\":\"" + expectedEvent.getEndTime().format(formatter));
        b.append("\",\"persons\":" + expectedEvent.getPersons());
        b.append("}");
        assertEquals(b.toString(), JsonUtility.toJson(expectedEvent));
	}
}
