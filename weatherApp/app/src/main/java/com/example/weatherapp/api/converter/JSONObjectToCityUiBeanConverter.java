package com.example.weatherapp.api.converter;

import com.example.weatherapp.model.uiBean.CityUiBean;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONObjectToCityUiBeanConverter {

    public static CityUiBean convert(final JSONObject json) {
        final CityUiBean uiBean = new CityUiBean();
        try {
            uiBean.setName((String) json.get("name"));
            uiBean.setCurrentWeather(JSONObjectToWeatherUiBeanConverter.convert(json));
        } catch (final JSONException e) {
            e.printStackTrace();
        }
        return uiBean;
    }
}
