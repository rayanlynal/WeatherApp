package util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONException;
import org.json.JSONObject;

public class Utils {

    public static boolean hasInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public static final String BASE_URL = "https://api.darksky.net/forecast/4fcf0d2ae5be0c28c6db9099bc8b692c/37.8267,-122.4233";
    // public static final String ICON_URL ="https://api.darksky.net/forecast/4fcf0d2ae5be0c28c6db9099bc8b692c/37.8267,-122.4233";

    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException {
        JSONObject jObj = jsonObject.getJSONObject(tagName);
        return jObj;
    }

    public static String getString(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getString(tagName);
    }

    public static float getFloat(String tagName, JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }

    public static double getDouble(String tagName, JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }

    public static int getInt(String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getInt(tagName);
    }
}
