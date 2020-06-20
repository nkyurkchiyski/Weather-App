package com.example.weatherapp.api.converter;

import com.example.weatherapp.model.uiBean.WeatherUiBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONObjectToWeatherUiBeanConverter {

    public static WeatherUiBean convert(final JSONObject json) {

        final WeatherUiBean uiBean = new WeatherUiBean();
        try {
            final JSONObject main = json.getJSONObject("main");
            final JSONArray weather = json.getJSONArray("weather");
            final Object weatherType = weather.getJSONObject(0).get("main");

            uiBean.setCurrentTemperature(convertTemperatureToString(main.get("temp")));
            uiBean.setMinTemperature(convertTemperatureToString(main.get("temp_min")));
            uiBean.setMaxTemperature(convertTemperatureToString(main.get("temp_max")));
            uiBean.setWeatherType((String) weatherType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return uiBean;
    }


    private static String convertTemperatureToString(final Object temp) {
        if (temp instanceof Double) {
            return String.format("%s°C", ((Double) temp).intValue());
        }
        return String.format("%s°C", temp);
    }
}
