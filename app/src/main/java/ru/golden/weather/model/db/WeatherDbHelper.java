package ru.golden.weather.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static ru.golden.weather.model.db.WeatherContract.SQL_CREATE_WEATHER_ENTRIES;
import static ru.golden.weather.model.db.WeatherContract.SQL_DELETE_WEATHER_ENTRIES;

public class WeatherDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Weather.db";

    public WeatherDbHelper(final Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_WEATHER_ENTRIES);
    }

    @Override
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int oldVersion, final int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE_WEATHER_ENTRIES);
        onCreate(sqLiteDatabase);
    }
}
