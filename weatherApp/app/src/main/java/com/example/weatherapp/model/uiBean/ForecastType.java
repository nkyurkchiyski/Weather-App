package com.example.weatherapp.model.uiBean;

public enum ForecastType {
    CURRENT("Current Forecast"),NEXT_5_DAYS("Next 5 days Forecast");

    private String text;

    ForecastType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static ForecastType getByText(final String text){
        for (final ForecastType type : ForecastType.values()) {
            if (type.getText().equals(text)){
                return type;
            }
        }
        return null;
    }

}
