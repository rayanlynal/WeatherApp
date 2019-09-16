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
    protected ObservableBoolean busy = new ObservableBoolean();

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
        Repository.getInstance().callWeatherAPI("", "")
                .observe(this, basicResponse -> {
                    busy.set(false);
                    try {
                        /*if (basicResponse != null && basicResponse.isSuccessful()) {
                         *//*Toast.makeText(this, basicResponse.body().getMessage(), Toast.LENGTH_SHORT).show();*//*
                            onBackPressed();
                        } else {
                            if (basicResponse.errorBody() != null) {
                                *//*Toast.makeText(this, basicResponse.body().getMessage(), Toast.LENGTH_SHORT).show();*//*
                            }
                        }*/
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }
}
