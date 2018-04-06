package ru.golden.weather.model.db;

import android.provider.BaseColumns;

public class WeatherContract {

    public WeatherContract() {
    }

    public static abstract class WeatherEntry implements BaseColumns {

        public static final String TABLE_NAME = "weather";

        public static final String COLUMN_ID = "id";

        public static final String COLUMN_TEMP = "temp";

        public static final String COLUMN_PRESSURE = "pressure";

        public static final String COLUMN_HUMIDITY = "humidity";

        public static final String COLUMN_WIND_SPEED = "wind_speed";

        public static final String COLUMN_CLOUDINESS = "cloudiness";

        public static final String COLUMN_NAME = "name";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    static final String SQL_CREATE_WEATHER_ENTRIES =
            "CREATE TABLE " + WeatherEntry.TABLE_NAME + " (" +
                    WeatherEntry.COLUMN_ID + " INTEGER PRIMARY KEY," +
                    WeatherEntry.COLUMN_TEMP + TEXT_TYPE + COMMA_SEP +
                    WeatherEntry.COLUMN_PRESSURE + TEXT_TYPE + COMMA_SEP +
                    WeatherEntry.COLUMN_HUMIDITY + TEXT_TYPE + COMMA_SEP +
                    WeatherEntry.COLUMN_WIND_SPEED + TEXT_TYPE + COMMA_SEP +
                    WeatherEntry.COLUMN_CLOUDINESS + TEXT_TYPE + COMMA_SEP +
                    WeatherEntry.COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
                    " )";

    static final String SQL_DELETE_WEATHER_ENTRIES =
            "DROP TABLE IF EXISTS " + WeatherEntry.TABLE_NAME;
}
