package com.example.weatherapp.api;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.weatherapp.R;
import com.example.weatherapp.adapter.WeatherAdapter;
import com.example.weatherapp.api.converter.JSONObjectToCityUiBeanConverter;
import com.example.weatherapp.model.uiBean.CityUiBean;
import com.example.weatherapp.model.uiBean.ForecastType;
import com.example.weatherapp.model.uiBean.WeatherEntryUiBean;
import com.example.weatherapp.views.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SuccessfulResponseListener implements Response.Listener<String> {

    private final BaseActivity activity;
    private final ForecastType type;

    public SuccessfulResponseListener(final BaseActivity activity, final ForecastType type) {
        this.activity = activity;
        this.type = type;
    }

    @Override
    public void onResponse(final String response) {
        try {
            final JSONObject result = new JSONObject(response);
            switch (type){
                case CURRENT:
                    fillCurrentForecast(result);
                    break;
                case NEXT_5_DAYS:
                    fill5DayForecast(result);
                    break;
            }
        } catch (final JSONException e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void fillCurrentForecast(final JSONObject result) {
        final CityUiBean bean = JSONObjectToCityUiBeanConverter.convert(result);
        ((TextView) activity.findViewById(R.id.mCityText)).setText(bean.getName());
        ((TextView) activity.findViewById(R.id.mCurrentTempText)).setText(bean.getCurrentWeather().getCurrentTemperature());
        ((TextView) activity.findViewById(R.id.mDailyTempText)).setText(String.format("%s / %s",
                bean.getCurrentWeather().getMinTemperature(),
                bean.getCurrentWeather().getMaxTemperature()));
        ((TextView) activity.findViewById(R.id.mWeatherText)).setText(bean.getCurrentWeather().getWeatherType());
    }

    private void fill5DayForecast(final JSONObject result) {
        //TODO

        final ListView listView = activity.findViewById(R.id.listViewWeather);
        listView.setAdapter(new WeatherAdapter(activity, createList()));
    }


    private List<WeatherEntryUiBean> createList() {
        final List<WeatherEntryUiBean> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            final WeatherEntryUiBean bean = new WeatherEntryUiBean();
            bean.setDay("Friday");
            bean.setHour("12:00");
            bean.setTemp("12C/13C");
            bean.setWeatherType("Rainy");
            list.add(bean);
        }
        return list;
    }
}
