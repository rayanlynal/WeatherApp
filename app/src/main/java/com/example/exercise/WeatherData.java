package com.example.exercise;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Weather_database")
public class WeatherData {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int temperature;
    private int pressure;
    private int cloud;
    private int humidity;

    public WeatherData(int temperature, int pressure, int cloud, int humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.cloud = cloud;
        this.humidity = humidity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public int getCloud() {
        return cloud;
    }

    public int getHumidity() {
        return humidity;
    }
}
