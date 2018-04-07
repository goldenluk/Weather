package ru.golden.weather.model;

public class URLCreator {

    private static final String KEY = "ad152f53f3a00f1cac75b4634245baae";
    private static final String URL_PREFIX = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String KEY_PREFIX = "&APPID=";

    public static String getCurrentWeatherUrl(final String cityName) {
        return URL_PREFIX + cityName + KEY_PREFIX + KEY;
     }
}
