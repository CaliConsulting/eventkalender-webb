package cali.eventkalender.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.JUnit4;

import cali.eventkalender.api.weather.OpenWeatherMapClient;

@RunWith(JUnit4.class)
public class OpenWeatherMapClientTest {
	private OpenWeatherMapClient owm;
	
	@Before
	public void setup(){
		owm = OpenWeatherMapClient.getInstance();
	}
	
	@Test
	public void getInstance() {
		assertNotNull(owm);
	}

	@Test
	public void getCurrentWeather() {
		assertNotNull(owm.getCurrentWeather("Lund"));
	}
	@Test
	public void getTemperature() {
		assertNotNull(owm.getTemperature("Lund"));
	}
	@Test
	public void getIconLink() {
		assertNotNull(owm.getIconLink("Lund"));
	}
}
