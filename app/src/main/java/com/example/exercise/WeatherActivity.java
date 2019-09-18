package com.example.exercise;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;

import com.example.exercise.databinding.ActivityMainBinding;

import remote.Repository;
import util.Utils;

public class WeatherActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    protected ObservableBoolean busy = new ObservableBoolean(false);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setBusy(busy);
        callApiToFetchWeather();
    }

    private void callApiToFetchWeather() {
        busy.set(true);
        if (Utils.hasInternet(this)) {
            callChangePasswordApi();
        } else {
            Toast.makeText(this, "Please check your internet connection!", Toast.LENGTH_SHORT).show();
        }
        //set busy false
    }

    private void callChangePasswordApi() {
        busy.set(true);
        Repository.getInstance().callWeatherAPI()
                .observe(this, weatherMainModelResponse -> {
                    busy.set(false);
                    try {
                        if (weatherMainModelResponse != null && weatherMainModelResponse.isSuccessful()) {
                            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                        } else {
                            if (weatherMainModelResponse.errorBody() != null) {
                                Toast.makeText(WeatherActivity.this, weatherMainModelResponse.errorBody().string()
                                        , Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
