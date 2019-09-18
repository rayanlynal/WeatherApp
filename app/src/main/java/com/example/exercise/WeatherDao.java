package com.example.exercise;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WeatherDao {
    @Insert
    void insert(WeatherData weatherData);

    @Update
    void update(WeatherData weatherData);

    @Delete
    void delete (WeatherData weatherData);

    @Query("Delete from weather_database")
    void deleteAllNotes();

    @Query("Select * from weather_database")
    LiveData<List<WeatherData>> getAllWeather();


}
