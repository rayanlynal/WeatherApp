package remote;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

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

    public LiveData<Object> callWeatherAPI(String currentPassword, String newPassword) {
        MutableLiveData<Object> changePassword = new MutableLiveData<>();
        RemoteAPI.createService(ApiList.class, false).loginUser("", "")
                .enqueue(new Callback<Response>() {
                    @Override
                    public void onResponse(Call<Response> call, Response<Response> response) {
                        changePassword.setValue(response);
                    }

                    @Override
                    public void onFailure(Call<Response> call, Throwable t) {
                        changePassword.setValue(null);
                    }
                });
        return changePassword;
    }
}
