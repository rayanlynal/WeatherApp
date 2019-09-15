package util;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils {
    public static final String BASE_URL ="https://api.darksky.net/forecast/4fcf0d2ae5be0c28c6db9099bc8b692c/37.8267,-122.4233";
   // public static final String ICON_URL ="https://api.darksky.net/forecast/4fcf0d2ae5be0c28c6db9099bc8b692c/37.8267,-122.4233";

    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException {
        JSONObject jObj = jsonObject.getJSONObject(tagName);
        return jObj;
    }

    public static String getString(String tagName, JSONObject jsonObject) throws JSONException{
        return jsonObject.getString(tagName);
    }

    public static float getFloat(String tagName, JSONObject jsonObject) throws JSONException{
        return (float) jsonObject.getDouble(tagName);
    }

    public static double getDouble(String tagName, JSONObject jsonObject) throws JSONException{
        return (float) jsonObject.getDouble(tagName);
    }

    public static int getInt(String tagName, JSONObject jsonObject) throws JSONException{
        return jsonObject.getInt(tagName);
    }
}
