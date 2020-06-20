package com.example.weatherapp.model.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String CREATE_HISTORY_TABLE =
            "CREATE TABLE " + DBConstants.HISTORY_TABLE_NAME +
                    " (" + DBConstants.History.HISTORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DBConstants.History.HISTORY_CITY + " TEXT NOT NULL, " +
                    DBConstants.History.HISTORY_QUERY + " TEXT NOT NULL, " +
                    DBConstants.History.HISTORY_FORECAST_TYPE + " TEXT NOT NULL);";

    public DBHelper(final Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        db.execSQL(CREATE_HISTORY_TABLE);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase db,
                          final int oldVersion,
                          final int newVersion) {
        db.execSQL(String.format(DBConstants.DROP_TABLE, DBConstants.HISTORY_TABLE_NAME));
        onCreate(db);
    }
}

