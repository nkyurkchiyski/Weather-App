package com.example.weatherapp.model.service.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.weatherapp.model.db.DBConstants;
import com.example.weatherapp.model.db.DBHelper;
import com.example.weatherapp.model.uiBean.HistoryUiBean;
import com.example.weatherapp.model.service.HistoryService;

import java.util.ArrayList;
import java.util.List;

public class HistoryServiceImpl implements HistoryService {
    private final DBHelper dbHelper;

    public HistoryServiceImpl(final DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public void create(String city, String forecastType, String query) {

        final ContentValues values = new ContentValues();
        values.put(DBConstants.History.HISTORY_CITY, city);
        values.put(DBConstants.History.HISTORY_FORECAST_TYPE, forecastType);
        values.put(DBConstants.History.HISTORY_QUERY, query);

        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(DBConstants.HISTORY_TABLE_NAME, null, values);
    }

    @Override
    public List<HistoryUiBean> getAll() {
        final SQLiteDatabase db = dbHelper.getReadableDatabase();

        final String[] projection = {
                DBConstants.History.HISTORY_ID,
                DBConstants.History.HISTORY_CITY,
                DBConstants.History.HISTORY_QUERY,
                DBConstants.History.HISTORY_FORECAST_TYPE
        };

        String sortOrder = DBConstants.History.HISTORY_ID + " DESC";

        final Cursor cursor = db.query(
                DBConstants.HISTORY_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder);
        return createHistoryList(cursor);
    }

    @Override
    public void delete(final String id) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(DBConstants.HISTORY_TABLE_NAME, String.format("%s = %s;", DBConstants.History.HISTORY_ID, id), null);
    }

    private List<HistoryUiBean> createHistoryList(final Cursor cursor) {
        final List<HistoryUiBean> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            final String id = cursor.getString(cursor.getColumnIndex(DBConstants.History.HISTORY_ID));
            final String city = cursor.getString(cursor.getColumnIndex(DBConstants.History.HISTORY_CITY));
            final String forecastType = cursor.getString(cursor.getColumnIndex(DBConstants.History.HISTORY_FORECAST_TYPE));
            final String query = cursor.getString(cursor.getColumnIndex(DBConstants.History.HISTORY_QUERY));
            list.add(new HistoryUiBean(id, city, forecastType, query));
        }
        cursor.close();
        return list;
    }
}
