package cali.eventkalender.api.weather;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.param.Weather;

/**
 * <p>Wrapper for OWM client.</p>
 */
public class OpenWeatherMapClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapClient.class);
    
    private static OpenWeatherMapClient client;

    private OWM owm;
    
    private TimedCache cache;

    private String apiKey;

    private OpenWeatherMapClient() {
        this.apiKey = "e33f7134856ab9fbbe79a544cc23bc39";

        owm = new OWM(this.apiKey);
        owm.setUnit(OWM.Unit.METRIC);
        
        cache = new TimedCache();
    }

    public static OpenWeatherMapClient getInstance() {
        if (client == null) {
            client = new OpenWeatherMapClient();
        }
        return client;
    }

    public CurrentWeather getCurrentWeather(String city) {
        try {
            if (isConnectionValid()) {
                CurrentWeather cwd = owm.currentWeatherByCityName(city, OWM.Country.SWEDEN);
                return cwd;
            }
            return null;
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTemperature(String city) {
    	if (!cache.isExpired("temperature")) {
    		return cache.getValue("temperature");
    	}
    	
        CurrentWeather cwd = getCurrentWeather(city);
        if (cwd == null) {
            return "--";
        }
        
        double temp = cwd.getMainData().getTemp();
        
        // Round temperature
        String roundedTemp = String.format("%.1f", temp);
        cache.setValue("temperature", roundedTemp);
        return roundedTemp;
    }

    public String getIconLink(String city) {
    	if (!cache.isExpired("iconLink")) {
    		return cache.getValue("iconLink");
    	}
    	
    	String iconLink = "";
        CurrentWeather cwd = getCurrentWeather(city);
        if (cwd != null) {
        	if (cwd.hasWeatherList()) {
            	// Det aktuella vädret är först i listan
                Weather weather = cwd.getWeatherList().get(0);
                iconLink = weather.getIconLink();
                cache.setValue("iconLink", iconLink);
                return iconLink;
        	}
        }
        // Vi vet inte vad vädret är
        iconLink = "/EventkalenderClient/img/questionmark.png";
        cache.setValue("iconLink", iconLink);
        return null;
    }
    
    private boolean isConnectionValid() {
        String address = "https://api.openweathermap.org/data/2.5/";
        try {
            URL url = new URL(address);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            LOGGER.info("Valid connection to API");
            return true;
        } catch (IOException e) {
            LOGGER.info("Invalid connection to API");
            return false;
        }
    }

}
