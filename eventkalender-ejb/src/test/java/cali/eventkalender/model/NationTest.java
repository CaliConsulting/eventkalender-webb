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
public class NationTest {

    private Nation expectedNationDefault;
    
    private Long expectedEventId;
    private String expectedEventName;
    private String expectedEventSummary;
    private LocalDateTime expectedEventStartTime;
    private LocalDateTime expectedEventEndTime;
    
    private Event expectedEvent;
    
    private Long expectedNationId;
    private String expectedNationName;
    
    private Nation expectedNationOverloaded;
    private Nation expectedNationOverloaded2;
    private Nation expectedNationRelations;
    
    @Before
    public void setup() {
        expectedNationDefault = new Nation();
        
        expectedNationId = -1L;
        expectedNationName = "TESTNATION";
        expectedNationOverloaded = new Nation(expectedNationName);
        expectedNationOverloaded.setId(expectedNationId);

        expectedEventId = Long.MIN_VALUE;
        expectedEventName = "TESTEVENT";
        expectedEventSummary = "TESTSAMMANFATTNING";
        expectedEventStartTime = LocalDateTime.of(2000, 1, 1, 12, 0);
        expectedEventEndTime = LocalDateTime.of(2000, 1, 1, 14, 0);
        expectedEvent = new Event(expectedEventName, expectedEventSummary, expectedEventStartTime,
                expectedEventEndTime);
        expectedEvent.setId(expectedEventId);
        expectedEvent.setNation(expectedNationOverloaded);
        
        // Copy nation to use in equals test
        expectedNationOverloaded2 = new Nation(expectedNationName);
        expectedNationOverloaded2.setId(expectedNationId);
        
        // Use for relation test
        expectedNationRelations = new Nation(expectedNationName, Arrays.asList(expectedEvent));
        expectedNationRelations.setId(expectedNationId);
    }
    
	@Test
	public void constructorDefault() {
		assertEquals(Long.valueOf(Long.MIN_VALUE), expectedNationDefault.getId());
		assertNull(expectedNationDefault.getName());
		assertEquals(0, expectedNationDefault.getEvents().size());
	}

	@Test
	public void constructorValues() {
        assertEquals(expectedNationId, expectedNationOverloaded.getId());
		assertEquals(expectedNationName, expectedNationOverloaded.getName());
	}
	
	@Test
	public void constructorRelations() {
        assertEquals(expectedNationId, expectedNationRelations.getId());
        assertEquals(expectedNationName, expectedNationRelations.getName());
		assertEquals(1, expectedNationRelations.getEvents().size());
	}

	@Test
	public void getId() {
		assertEquals(expectedNationId, expectedNationOverloaded.getId());
	}

	@Test
	public void setId() {
	    expectedNationOverloaded.setId(Long.MAX_VALUE);
		assertEquals(Long.valueOf(Long.MAX_VALUE), expectedNationOverloaded.getId());
	}

	@Test
	public void getName() {
	    assertEquals(expectedNationName, expectedNationOverloaded.getName());
	}

	@Test
	public void setName() {
	    expectedNationOverloaded.setName("ANOTHERTESTNATION");
        assertEquals("ANOTHERTESTNATION", expectedNationOverloaded.getName());
	}

	@Test
	public void equals() {
        Nation nation = new Nation(expectedNationName);
        nation.setId(expectedNationId);
		assertEquals(nation, expectedNationOverloaded);
	}

	@Test
	public void equalsItself() {
		assertEquals(expectedNationOverloaded, expectedNationOverloaded);
	}

	@Test
	public void equalsOtherInstanceWithValues() {
		assertEquals(expectedNationOverloaded, expectedNationOverloaded2);
	}

	@Test
	public void notEqualsNull() {
		assertNotEquals(null, expectedNationOverloaded);
	}
	
	@Test
	public void notEqualsNullParameter() {
		assertFalse(expectedNationOverloaded.equals(null));
	}
	
	@Test
	public void notEqualsIncompatibleObject() {
		assertNotEquals(new Object(), expectedNationOverloaded);
	}
	
	@Test
	public void notEqualsIncompatibleObjectParameter() {
		assertFalse(expectedNationOverloaded.equals(new Object()));
	}

	@Test
	public void equalsId() {
		assertEquals(expectedNationOverloaded, expectedNationOverloaded2);
	}
	
	@Test
	public void notEqualsId() {
	    expectedNationOverloaded2.setId(Long.MAX_VALUE);
		assertNotEquals(expectedNationOverloaded, expectedNationOverloaded2);
	}
	
	@Test
	public void equalsName() {
        assertEquals(expectedNationOverloaded, expectedNationOverloaded2);
	}
	
	@Test
	public void notEqualsName() {
	    expectedNationOverloaded2.setName("ANOTHERTESTNATION");
		assertNotEquals(expectedNationOverloaded, expectedNationOverloaded2);
	}
	
	@Test
	public void equalsHashCode() {
		assertEquals(expectedNationOverloaded.hashCode(), expectedNationOverloaded.hashCode());
	}
	
	@Test
	public void notEqualsHashCode() {
	    expectedNationOverloaded2.setId(Long.MAX_VALUE);
		assertNotEquals(expectedNationOverloaded.hashCode(), expectedNationOverloaded2.hashCode());
	}
	
}

