package com.example.weatherapp.model.uiBean;

public class WeatherUiBean {
    private Integer currentTemperature;
    private Integer minTemperature;
    private Integer maxTemperature;
    private String weatherType;
    private String weatherImage;

    public String getWeatherImage() {
        return weatherImage;
    }

    public void setWeatherImage(final String weatherImage) {
        this.weatherImage = weatherImage;
    }

    public Integer getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(final Integer currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Integer getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(final Integer minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Integer getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(final Integer maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(final String weatherType) {
        this.weatherType = weatherType;
    }
}
