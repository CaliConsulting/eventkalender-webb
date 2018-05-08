package cali.eventkalender.utility;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimedCache {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TimedCache.class);
	
	private int seconds;
	
	private Map<String, LocalDateTime> timings;
	private Map<String, String> actualCache;
	
	public TimedCache(int seconds) {
		this.timings = new HashMap<>();
		this.actualCache = new HashMap<>();
	}
	
	public void setValue(String key, String value) {
		if (!timings.containsKey(key)) {
			timings.put(key, LocalDateTime.now());
		}
		LOGGER.info("Caching {}, value: {}", key, value);
		actualCache.put(key, value);
	}
	
	public String getValue(String key) {
		return actualCache.get(key);
	}
	
	public boolean isExpired(String key) {
		if (!timings.containsKey(key)) {
			return true;
		}
		LocalDateTime expiration = timings.get(key).plusSeconds(seconds);
		if (LocalDateTime.now().isAfter(expiration)) {
			return true;
		}
		return false;
	}
	
}
