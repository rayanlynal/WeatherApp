package remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import beans.WeatherMainModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) {
            synchronized (Repository.class) {
                if (instance == null) {
                    instance = new Repository();
                }
            }
        }
        return instance;
    }

    public LiveData<Response<WeatherMainModel>> callWeatherAPI() {
        MutableLiveData<Response<WeatherMainModel>> weatherModel = new MutableLiveData<>();

        RemoteAPI.createService(ApiList.class)
                .callWeatherAPI("4fcf0d2ae5be0c28c6db9099bc8b692c", "37.8267,-122.4233")
                .enqueue(new Callback<WeatherMainModel>() {
                             @Override
                             public void onResponse(Call<WeatherMainModel> call, Response<WeatherMainModel> response) {
                                 weatherModel.setValue(response);
                             }

                             @Override
                             public void onFailure(Call<WeatherMainModel> call, Throwable t) {
                                 weatherModel.setValue(null);
                                 t.printStackTrace();
                             }
                         }
                );
        return weatherModel;
    }

}
