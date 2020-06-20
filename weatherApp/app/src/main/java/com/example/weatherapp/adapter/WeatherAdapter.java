package com.example.weatherapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.weatherapp.R;
import com.example.weatherapp.model.uiBean.ForecastType;
import com.example.weatherapp.model.uiBean.WeatherEntryUiBean;

import java.util.List;

public class WeatherAdapter extends ArrayAdapter<WeatherEntryUiBean> {
    private Context context;
    private List<WeatherEntryUiBean> weatherEntryUiBeans;

    public WeatherAdapter(final Context context, final List<WeatherEntryUiBean> weatherEntryUiBeans)
    {
        super(context, R.layout.weather_layout, weatherEntryUiBeans);

        this.context = context;
        this.weatherEntryUiBeans = weatherEntryUiBeans;
    }

    @NonNull
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.weather_layout, parent, false);
        final WeatherEntryUiBean bean = weatherEntryUiBeans.get(position);

        final TextView textDay = view.findViewById(R.id.textViewDay);
        textDay.setText(bean.getDay());

        final TextView textHour = view.findViewById(R.id.textViewHour);
        textHour.setText(bean.getHour());

        final TextView textWeather = view.findViewById(R.id.textViewWeatherType);
        textWeather.setText(bean.getWeatherType());

        final TextView textTemp = view.findViewById(R.id.textViewTemp);
        textTemp.setText(bean.getTemp());

        return view;
    }
}
