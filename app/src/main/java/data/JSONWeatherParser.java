package data;

import org.json.JSONException;
import org.json.JSONObject;

import model.Place;
import model.Weather;
import util.Utils;

public class JSONWeatherParser {
    Weather weather = new Weather();

    public static Weather getWeather(String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            Place place = new Place();
            // get coord object
            JSONObject coorObj = Utils.getObject("coord", jsonObject);
            place.setLat(Utils.getFloat("lat", coorObj));
            place.setLon(Utils.getFloat("lon", coorObj));

            //get sys object
            JSONObject sysObj = Utils.getObject("sys", jsonObject);
            place.setCountry(Utils.getString("country", sysObj));
            place.setLastupdate(Utils.getInt("dt", jsonObject));
            place.setSunrise(Utils.getInt("sunrise", sysObj));
            place.setSunset(Utils.getInt("sunset", sysObj));
            place.setCity(Utils.getString("name", jsonObject));
            /*weather.place = place;


            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            Weather.currentCondition.setWeatherId(Utils.getInt("id", jsonWeather));
            Weather.currentCondition.setDescription(Utils.getString("description", jsonObject));
            Weather.currentCondition.setCondition(Utils.getString("main",jsonWeather));
            Weather.currentConditon.setIcon(Utils.getString("icon", jsonWeather));

            JSONObject windobj = Utils.getObject("wind", jsonObject);
            Weather.wind.setSpeed(Utils.getFloat("speed", windobj));
            Weather.wind.setDeg(Utils.getString("deg", windobj));

            JSONObject cloudobj = Utils.getObject("clouds", jsonObject);
            Weather.clouds.setPrecipitation(Utils.getInt("all", cloudobj));

            return weather;*/

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }
}