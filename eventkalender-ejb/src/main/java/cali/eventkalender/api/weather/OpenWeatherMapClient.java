package cali.eventkalender.api.weather;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.param.Weather;

/**
 * <p>Wrapper for OWM client.</p>
 */
public class OpenWeatherMapClient {

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
            CurrentWeather cwd = owm.currentWeatherByCityName("Lund", OWM.Country.SWEDEN);
            return cwd;
        } catch (APIException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTemperature(String city) {
        double temp = getCurrentWeather(city).getMainData().getTemp();
        // Round temperature
        return String.format("%.1f", temp);
    }

    public String getIconLink(String city) {
        CurrentWeather cwd = getCurrentWeather(city);
        if (cwd.hasWeatherList()) {
            // We want the current weather; it is first in the list
            Weather weather = cwd.getWeatherList().get(0);
            return weather.getIconLink();
        }
        return null;
    }

}
