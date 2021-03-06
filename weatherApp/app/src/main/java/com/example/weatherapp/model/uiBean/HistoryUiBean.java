package com.example.weatherapp.model.uiBean;


import java.io.Serializable;

public class HistoryUiBean implements Serializable {

    private String id;
    private String city;
    private String query;
    private String forecastType;


    public HistoryUiBean(final String id,
                         final String city,
                         final String forecastType,
                         final String query) {
        this.id = id;
        this.city = city;
        this.forecastType = forecastType;
        this.query = query;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getForecastType() {
        return forecastType;
    }

    public void setForecastType(final String forecastType) {
        this.forecastType = forecastType;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(final String query) {
        this.query = query;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}
