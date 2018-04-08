package ru.golden.weather.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ru.golden.weather.model.db.tables.WeatherTable;

public class WeatherDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Weather.db";

    public WeatherDbHelper(final Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(final SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(WeatherTable.getCreateTableQuery());
    }

    @Override
    public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int oldVersion, final int newVersion) {
    }
}
