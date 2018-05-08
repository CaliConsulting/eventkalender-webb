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

    private String apiKey;

    private OpenWeatherMapClient() {
        this.apiKey = "e33f7134856ab9fbbe79a544cc23bc39";

        owm = new OWM(this.apiKey);
        owm.setUnit(OWM.Unit.METRIC);
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
                CurrentWeather cwd = owm.currentWeatherByCityName("Lund", OWM.Country.SWEDEN);
                return cwd;
            }
            return null;
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTemperature(String city) {
        CurrentWeather cwd = getCurrentWeather(city);
        if (cwd == null) {
            return "--";
        }
        double temp = cwd.getMainData().getTemp();
        // Round temperature
        return String.format("%.1f", temp);
    }

    public String getIconLink(String city) {
        CurrentWeather cwd = getCurrentWeather(city);
        if (cwd == null) {
            // Fullösning men låt gå, om nu API:t skulle gå ner
            return "/EventkalenderClient/img/questionmark.png";
        }
        if (cwd.hasWeatherList()) {
            // We want the current weather; it is first in the list
            Weather weather = cwd.getWeatherList().get(0);
            return weather.getIconLink();
        }
        return null;
    }
    
    private boolean isConnectionValid() {
        String strUrl = "https://api.openweathermap.org/data/2.5/";
        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();
            LOGGER.info("valid connection");
            return true;
        } catch (IOException e) {
            LOGGER.info("invalid connection");
            return false;
        }
    }

}
