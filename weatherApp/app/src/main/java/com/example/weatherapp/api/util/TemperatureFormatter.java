package com.example.weatherapp.api.util;

public class TemperatureFormatter {
    public static String getTemperatureBounds(final Object minTemp, final Object maxTemp) {
        return String.format("%s°C / %s°C", minTemp, maxTemp);
    }

    public static String getTemperature(final Object temp) {
        if (temp instanceof Double) {
            return String.format("%s°C", ((Double) temp).intValue());
        }
        return String.format("%s°C", temp);
    }

}
