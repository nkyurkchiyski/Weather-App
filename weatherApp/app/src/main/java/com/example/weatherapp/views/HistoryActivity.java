package com.example.weatherapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.weatherapp.R;
import com.example.weatherapp.adapter.HistoryAdapter;
import com.example.weatherapp.model.db.DBHelper;
import com.example.weatherapp.model.uiBean.ForecastType;
import com.example.weatherapp.model.uiBean.HistoryUiBean;
import com.example.weatherapp.model.service.HistoryService;
import com.example.weatherapp.model.service.impl.HistoryServiceImpl;

import java.util.List;

public class HistoryActivity extends BaseActivity {

    private HistoryService service;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.title_activity_history);
        setContentView(R.layout.activity_history);

        service = new HistoryServiceImpl(new DBHelper(getApplicationContext()));
        final List<HistoryUiBean> list = service.getAll();

        final ListView listViewHistory = findViewById(R.id.listViewHistory);
        listViewHistory.setAdapter(new HistoryAdapter(this, list));

        listViewHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
                final HistoryUiBean historyUiBean = list.get(position);
                final Intent intent = new Intent(HistoryActivity.this, MainActivity.class);

                intent.putExtra("QUERY", historyUiBean.getQuery());
                intent.putExtra("FORECAST_TYPE", historyUiBean.getForecastType());
                startActivity(intent);
            }
        });

    }
}
