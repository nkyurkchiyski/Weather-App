package com.example.weatherapp.api.converter;

import com.example.weatherapp.model.uiBean.WeatherImageResource;
import com.example.weatherapp.model.uiBean.WeatherUiBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONObjectToWeatherUiBeanConverter {

    public static WeatherUiBean convert(final JSONObject json) throws JSONException {

        final WeatherUiBean uiBean = new WeatherUiBean();
        final JSONObject main = json.getJSONObject(ApiJSONKey.MAIN);
        final JSONArray weather = json.getJSONArray(ApiJSONKey.WEATHER);
        final Object weatherType = weather.getJSONObject(0).get(ApiJSONKey.MAIN);

        uiBean.setCurrentTemperature(JSONParser.getIntegerValue(main.get(ApiJSONKey.TEMP)));
        uiBean.setMinTemperature(JSONParser.getIntegerValue(main.get(ApiJSONKey.TEMP_MIN)));
        uiBean.setMaxTemperature(JSONParser.getIntegerValue(main.get(ApiJSONKey.TEMP_MAX)));
        uiBean.setWeatherType((String) weatherType);
        uiBean.setWeatherImage(WeatherImageResource.valueOf(uiBean.getWeatherType().toUpperCase()).getResource());
        return uiBean;
    }
}
