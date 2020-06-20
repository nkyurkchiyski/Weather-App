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
import com.example.weatherapp.model.uiBean.HistoryUiBean;

import java.util.List;

public class HistoryAdapter extends ArrayAdapter<HistoryUiBean> {
    private Context context;
    private List<HistoryUiBean> historyList;

    public HistoryAdapter(final Context context, final List<HistoryUiBean> historyList)
    {
        super(context, R.layout.history_layout, historyList);

        this.context = context;
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        final LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.history_layout, parent, false);

        final TextView textViewCity = view.findViewById(R.id.textViewCity);
        textViewCity.setText(historyList.get(position).getCity());

        final TextView textViewForecastType = view.findViewById(R.id.textViewForecastType);
        textViewForecastType.setText(ForecastType.valueOf(historyList.get(position).getForecastType()).getText());

        final TextView textQuery = view.findViewById(R.id.textQuery);
        textQuery.setText(historyList.get(position).getQuery());

        return view;
    }

}
