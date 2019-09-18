package remote;

import beans.WeatherMainModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiList {

    @GET("forecast/{key}/{latitudelongitude}")
    Call<WeatherMainModel> callWeatherAPI(@Path("key") String key, @Path("latitudelongitude") String latitudelongitude);

}