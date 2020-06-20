package com.example.weatherapp.model.uiBean;

import java.util.List;

public class CityUiBean {
    private String name;
    private WeatherUiBean currentWeather;
    private List<WeatherEntryUiBean> weatherEntries;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public WeatherUiBean getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(final WeatherUiBean currentWeather) {
        this.currentWeather = currentWeather;
    }

    public List<WeatherEntryUiBean> getWeatherEntries() {
        return weatherEntries;
    }

    public void setWeatherEntries(final List<WeatherEntryUiBean> weatherEntries) {
        this.weatherEntries = weatherEntries;
    }
}
