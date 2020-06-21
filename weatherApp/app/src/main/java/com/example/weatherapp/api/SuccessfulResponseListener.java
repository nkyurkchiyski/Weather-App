package com.example.weatherapp.api;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

import com.android.volley.Response;
import com.example.weatherapp.R;
import com.example.weatherapp.adapter.WeatherAdapter;
import com.example.weatherapp.api.converter.JSONObjectToCityUiBeanConverter;
import com.example.weatherapp.api.util.TemperatureFormatter;
import com.example.weatherapp.model.uiBean.CityUiBean;
import com.example.weatherapp.model.uiBean.ForecastType;
import com.example.weatherapp.model.uiBean.WeatherEntryUiBean;
import com.example.weatherapp.views.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
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
            final CityUiBean bean = JSONObjectToCityUiBeanConverter.convert(result, type);
            fillCurrentForecast(bean);
            if (type == ForecastType.NEXT_5_DAYS) {
                fill5DayForecast(bean);
            }
        } catch (final JSONException | ParseException e) {
            Toast.makeText(activity, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void fillCurrentForecast(final CityUiBean bean) {
        if (bean != null) {
            ((TextView) activity.findViewById(R.id.mCityText)).setText(bean.getName());
            ((TextView) activity.findViewById(R.id.mCurrentTempText)).setText(TemperatureFormatter.getTemperature(bean.getCurrentWeather().getCurrentTemperature()));
            ((TextView) activity.findViewById(R.id.mDailyTempText)).setText(TemperatureFormatter.getTemperatureBounds(
                    bean.getCurrentWeather().getMinTemperature(),
                    bean.getCurrentWeather().getMaxTemperature()));
            ((TextView) activity.findViewById(R.id.mWeatherText)).setText(bean.getCurrentWeather().getWeatherType());

            final int imageId = activity.getResources().getIdentifier(bean.getCurrentWeather().getWeatherImage(), "drawable", activity.getPackageName());
            ((ImageView) activity.findViewById(R.id.mWeatherImage)).setImageResource(imageId);
        }
    }

    private void fill5DayForecast(final CityUiBean bean) {
        if (bean != null) {
            final ListView listView = activity.findViewById(R.id.listViewWeather);
            listView.setAdapter(new WeatherAdapter(activity, bean.getWeatherEntries()));
        }
    }
}
