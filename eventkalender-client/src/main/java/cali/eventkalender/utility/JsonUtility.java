package cali.eventkalender.utility;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cali.eventkalender.model.Event;

public class JsonUtility {

    public static String toCalendarJson(List<Event> events) {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        JsonArray array = new JsonArray();
        for (Event e : events) {
            JsonObject obj = new JsonObject();
            obj.addProperty("title", e.getName());
            obj.addProperty("start", e.getStartTime().format(formatter));
            obj.addProperty("end", e.getEndTime().format(formatter));
            array.add(obj);
        }
        return array.toString();
    }
    
}
