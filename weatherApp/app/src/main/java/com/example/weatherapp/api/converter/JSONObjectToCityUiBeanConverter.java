package com.example.weatherapp.api.converter;

import com.example.weatherapp.model.uiBean.CityUiBean;
import com.example.weatherapp.model.uiBean.ForecastType;
import com.example.weatherapp.model.uiBean.WeatherEntryUiBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JSONObjectToCityUiBeanConverter {

    public static CityUiBean convert(final JSONObject json, final ForecastType type) throws JSONException, ParseException {
        switch (type) {
            case CURRENT:
                return convertDailyForecast(json);
            case NEXT_5_DAYS:
                return convert5DayForecast(json);
        }
        return null;
    }

    private static CityUiBean convertDailyForecast(final JSONObject json) throws JSONException {
        final CityUiBean uiBean = new CityUiBean();
        uiBean.setName((String) json.get(ApiJSONKey.NAME));
        uiBean.setCurrentWeather(JSONObjectToWeatherUiBeanConverter.convert(json));
        return uiBean;
    }

    private static CityUiBean convert5DayForecast(final JSONObject json) throws JSONException, ParseException {
        final CityUiBean uiBean = new CityUiBean();
        uiBean.setName((String) json.getJSONObject(ApiJSONKey.CITY).get(ApiJSONKey.NAME));
        final JSONArray listOfForecasts = json.getJSONArray(ApiJSONKey.LIST);
        final List<WeatherEntryUiBean> weatherEntryUiBeans = new ArrayList<>();

        uiBean.setCurrentWeather(JSONObjectToWeatherUiBeanConverter.convert((JSONObject) listOfForecasts.get(0)));
        for (int i = 1; i < listOfForecasts.length(); i++) {
            weatherEntryUiBeans.add(JSONObjectToWeatherEntryUiBeanConverter.convert((JSONObject)listOfForecasts.get(i)));
        }
        uiBean.setWeatherEntries(weatherEntryUiBeans);
        return uiBean;
    }
}
