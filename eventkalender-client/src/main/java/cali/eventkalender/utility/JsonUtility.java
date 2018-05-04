package cali.eventkalender.utility;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cali.eventkalender.model.Event;

public class JsonUtility {

    public static String toCalendarJson(List<Event> events) {
        JsonArray array = new JsonArray();
        for (Event e : events) {
            JsonObject obj = new JsonObject();
            obj.addProperty("title", e.getName());
            obj.addProperty("start", e.getStartTime().toLocalDate().toString());
            obj.addProperty("end", e.getEndTime().toLocalDate().toString());
            array.add(obj);
        }
        return array.toString();
    }
    
}
