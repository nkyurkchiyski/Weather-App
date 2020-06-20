package com.example.weatherapp.api;

public class WeatherQueryProvider {
    private static final String API_APP_ID = "3555fe40392bbb491620a27e92b8f896";
    private static final String CITY_QUERY = "https://api.openweathermap.org/data/2.5/%s?q=%s&units=metric&appid=%s";
    private static final String GEO_QUERY = "https://api.openweathermap.org/data/2.5/%s?lat=%s&lon=%s&units=metric&appid=%s";
    private static final String TODAY = "weather";
    private static final String NEXT_5_DAYS = "forecast";

    public static String getDailyWeatherForecast(final String city) {
        return String.format(CITY_QUERY, TODAY, city.toLowerCase(), API_APP_ID);
    }

    public static String getDailyWeatherForecast(final int lat, final int lon) {
        return String.format(GEO_QUERY, TODAY, lat, lon, API_APP_ID);
    }

    public static String get5DayWeatherForecast(final String city) {
        return String.format(CITY_QUERY, NEXT_5_DAYS, city.toLowerCase(), API_APP_ID);
    }

    public static String get5DayWeatherForecast(final int lat, final int lon) {
        return String.format(GEO_QUERY, NEXT_5_DAYS, lat, lon, API_APP_ID);
    }

}
