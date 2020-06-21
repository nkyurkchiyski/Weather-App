package com.example.weatherapp.api.converter;

import java.math.BigDecimal;

public class JSONParser {

    public static Integer getIntegerValue(final Object result) {
        if (result instanceof Double) {
            return ((Double) result).intValue();
        } else if (result instanceof Long) {
            return ((Long) result).intValue();
        } else if (result instanceof BigDecimal) {
            return ((BigDecimal) result).intValue();
        }
        return (Integer) result;
    }
}
