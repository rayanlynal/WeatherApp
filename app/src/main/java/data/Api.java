package data;

import java.util.List;

import model.Weather;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.darksky.net/forecast/4fcf0d2ae5be0c28c6db9099bc8b692c/37.8267,-122.4233";

    @GET("account")
    Call<List<Weather>> getWeather();

    }

