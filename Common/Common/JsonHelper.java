package Common.Common;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonHelper {

    public static JsonObject getJsonObject(String jsonFilePath) {
        try {
            JsonObject obj = new JsonObject();
            Gson gson = new Gson();
            JsonReader reader = getJsonReader(jsonFilePath);
            obj = gson.fromJson(reader, JsonObject.class);
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    private static JsonReader getJsonReader(String jsonFilePath) {
        try {
            JsonReader reader;
            reader = new JsonReader(new FileReader(jsonFilePath));
            return reader;
        } catch (FileNotFoundException e) {
            return null;
        }
    }

}
