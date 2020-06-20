package com.example.weatherapp.views;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.weatherapp.R;
import com.example.weatherapp.api.ErrorResponseListener;
import com.example.weatherapp.api.SuccessfulResponseListener;
import com.example.weatherapp.api.WeatherQueryProvider;
import com.example.weatherapp.model.uiBean.ForecastType;

public class MainActivity extends BaseActivity{
    private RequestQueue queue;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title_activity_main);
        setContentView(R.layout.activity_main);
        fillDataInActivity();
    }

    private void fillDataInActivity() {
        queue = Volley.newRequestQueue(this);
        final Intent intent = getIntent();

        String query = intent.getStringExtra("QUERY");
        ForecastType forecastType = intent.getStringExtra("FORECAST_TYPE") != null
                ? ForecastType.valueOf(intent.getStringExtra("FORECAST_TYPE"))
                : null;

        if (query == null) {
            query = WeatherQueryProvider.getDailyWeatherForecast("plovdiv");
            forecastType = ForecastType.CURRENT;
        }

        final StringRequest stringRequest = createStringRequest(query, forecastType);
        queue.add(stringRequest);
    }


    private StringRequest createStringRequest(final String url, final ForecastType forecastType) {
        return new StringRequest(Request.Method.GET, url,
                new SuccessfulResponseListener(this, forecastType),
                new ErrorResponseListener(this));
    }
}
