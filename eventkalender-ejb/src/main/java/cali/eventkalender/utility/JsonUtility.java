package cali.eventkalender.utility;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
    
    public static String toJson(Object obj) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new RelationExcluder());
        
        Gson gson = gsonBuilder.create();
        return gson.toJson(obj);
    }
    
    private static class RelationExcluder implements ExclusionStrategy {
        
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            String name = f.getName();
            return name.equals("events") || name.equals("persons") || name.equals("nation");
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    }
    
}
