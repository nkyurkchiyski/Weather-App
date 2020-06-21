package com.example.weatherapp.model.uiBean;

public enum WeatherImageResource {
    THUNDERSTORM("ic_thunderstorm"),
    DRIZZLE("ic_drizzle"),
    RAIN("ic_rain"),
    SNOW("ic_snow"),
    MIST("ic_mist"),
    SMOKE("ic_mist"),
    HAZE("ic_mist"),
    DUST("ic_mist"),
    FOG("ic_mist"),
    SAND("ic_mist"),
    ASH("ic_mist"),
    SQUALL("ic_mist"),
    TORNADO("ic_mist"),
    CLEAR("ic_clear"),
    CLOUDS("ic_clouds");

    private String resource;

    WeatherImageResource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
