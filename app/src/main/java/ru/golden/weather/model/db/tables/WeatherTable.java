package ru.golden.weather.model.db.tables;

import android.support.annotation.NonNull;

public class WeatherTable {

    @NonNull
    public static final String TABLE = "weather";

    @NonNull
    public static final String COLUMN_ID = "_id";

    @NonNull
    public static final String COLUMN_DATE = "last_updated";

    @NonNull
    public static final String COLUMN_NAME = "name";

    @NonNull
    public static final String COLUMN_JSON = "json";

    private WeatherTable() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public static String getCreateTableQuery() {
        return "CREATE TABLE " + TABLE + "("
                + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY, "
                + COLUMN_NAME + " TEXT NOT NULL, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_JSON + " TEXT"
                + ");";
    }
}
