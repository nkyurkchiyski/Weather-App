package com.example.weatherapp.model.db;


public class DBConstants {
    public static final String DATABASE_NAME = "Weather";

    public static final String HISTORY_TABLE_NAME = "tHistory";

    public static final int DATABASE_VERSION = 1;

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS %1$s;";

    public static class History {
        public static final String HISTORY_ID = "cHisId";
        public static final String HISTORY_CITY = "cHisCity";
        public static final String HISTORY_QUERY = "cHisQuery";
        public static final String HISTORY_FORECAST_TYPE = "cHisForecastType";
    }
}