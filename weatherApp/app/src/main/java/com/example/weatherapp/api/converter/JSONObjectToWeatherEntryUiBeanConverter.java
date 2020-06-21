package com.example.weatherapp.api.converter;

import com.example.weatherapp.api.util.TemperatureFormatter;
import com.example.weatherapp.model.uiBean.WeatherEntryUiBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSONObjectToWeatherEntryUiBeanConverter {
    private final static DateFormat DATE_FORMAT =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final static DateFormat DAY_OF_THE_WEEK = new SimpleDateFormat("EEEE");
    private final static DateFormat TIME = new SimpleDateFormat("HH:mm");

    public static WeatherEntryUiBean convert(final JSONObject json) throws JSONException, ParseException {
        final WeatherEntryUiBean entryUiBean = new WeatherEntryUiBean();
        final JSONObject mainJson = json.getJSONObject(ApiJSONKey.MAIN);
        final JSONArray weather = json.getJSONArray(ApiJSONKey.WEATHER);
        final Object weatherType = weather.getJSONObject(0).get(ApiJSONKey.MAIN);

        entryUiBean.setTemp(TemperatureFormatter.getTemperatureBounds(JSONParser.getIntegerValue(mainJson.get(ApiJSONKey.TEMP_MIN)),
                JSONParser.getIntegerValue(mainJson.get(ApiJSONKey.TEMP_MAX))));
        entryUiBean.setWeatherType((String)weatherType);

        final Date date = DATE_FORMAT.parse((String) json.get(ApiJSONKey.DT_TXT));
        entryUiBean.setDay(DAY_OF_THE_WEEK.format(date));
        entryUiBean.setHour(TIME.format(date));

        return entryUiBean;
    }
}
