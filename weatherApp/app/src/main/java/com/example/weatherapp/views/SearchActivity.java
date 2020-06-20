package com.example.weatherapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.weatherapp.R;
import com.example.weatherapp.api.WeatherQueryProvider;
import com.example.weatherapp.model.db.DBHelper;
import com.example.weatherapp.model.service.HistoryService;
import com.example.weatherapp.model.service.impl.HistoryServiceImpl;
import com.example.weatherapp.model.uiBean.ForecastType;

public class SearchActivity extends BaseActivity {
    private static final String[] values = new String[]{"Current Forecast", "Next 5 days Forecast"};

    private HistoryService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title_activity_search);
        setContentView(R.layout.activity_search);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = findViewById(R.id.comboBox);
        spinner.setAdapter(adapter);
    }

    public void executeSearch(final View view) {
        final Spinner spinner = findViewById(R.id.comboBox);
        final ForecastType forecastType = ForecastType.getByText(spinner.getSelectedItem().toString());
        final String city = ((EditText) findViewById(R.id.cityInput)).getText().toString();

        if (forecastType != null && !city.isEmpty()) {
            String query = null;
            if (forecastType == ForecastType.CURRENT) {
                query = WeatherQueryProvider.getDailyWeatherForecast(city);
            } else if (forecastType == ForecastType.NEXT_5_DAYS) {
                query = WeatherQueryProvider.get5DayWeatherForecast(city);
            }

            service = new HistoryServiceImpl(new DBHelper(getApplicationContext()));
            service.create(city, forecastType.toString(), query);
            final Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("QUERY", query);
            startActivity(intent);
        }
    }
}
