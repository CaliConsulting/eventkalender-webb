package cali.eventkalender.utility;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import cali.eventkalender.model.Event;

public class JsonUtility {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtility.class);
    
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
        if (obj instanceof Event) {
            return toJson((Event) obj);
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new RelationExcluder());

        Gson gson = gsonBuilder.create();
        return gson.toJson(obj);
    }

    private static String toJson(Event e) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapterSerializer());
        gsonBuilder.setExclusionStrategies(new EventsExcluder());
        Gson gson = gsonBuilder.create();
        return gson.toJson(e);
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

    private static class EventsExcluder implements ExclusionStrategy {
        
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            String name = f.getName();
            return name.equals("events");
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
        
    }
    
    private static class LocalDateTimeAdapterSerializer implements JsonSerializer<LocalDateTime> {

        @Override
        public JsonElement serialize(LocalDateTime date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.format(DateTimeFormatter.ISO_DATE_TIME)); // "yyyy-mm-dd"
        }
        
    }

}
