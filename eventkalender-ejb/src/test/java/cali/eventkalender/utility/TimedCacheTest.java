package cali.eventkalender.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TimedCacheTest {

	private TimedCache cache;
	
	private String expectedKey;
	private String expectedValue;
	
	@Before
	public void setup() {
		cache = new TimedCache(1);
		
		expectedKey = "TESTKEY";
		expectedValue = "EXPECTEDVALUE";
	}
	
	@Test
	public void setValue() {
		cache.setValue(expectedKey, expectedValue);
		
		assertEquals(expectedValue, cache.getValue(expectedKey));
	}
	
	@Test
	public void setValueAlreadyHasKey() {
		cache.setValue(expectedKey, expectedValue);
		cache.setValue(expectedKey, expectedValue);
		
		assertEquals(expectedValue, cache.getValue(expectedKey));
	}
	
	@Test
	public void getValue() {
		cache.setValue(expectedKey, expectedValue);
		
		assertEquals(expectedValue, cache.getValue(expectedKey));
	}
	
	@Test
	public void getValueNonExistingKey() {
		assertEquals(null, cache.getValue(expectedKey));
	}
	
	@Test
	public void isExpired() throws InterruptedException {
		cache.setValue(expectedKey, expectedValue);
		Thread.sleep(1500);
		cache.setValue(expectedKey, expectedValue);
		
		assertTrue(cache.isExpired(expectedKey));
	}
	
	@Test
	public void isNotExpired() {
		cache.setValue(expectedKey, expectedValue);
		cache.setValue(expectedKey, expectedValue);
		
		assertFalse(cache.isExpired(expectedKey));
	}
	
	@Test
	public void isExpiredNonExistingKey() {
		assertTrue(cache.isExpired(expectedKey));
	}
	
}
