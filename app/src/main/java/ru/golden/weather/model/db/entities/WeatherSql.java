package ru.golden.weather.model.db.entities;

import com.pushtorefresh.storio3.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio3.sqlite.annotations.StorIOSQLiteType;

import lombok.Getter;
import lombok.Setter;
import ru.golden.weather.model.db.tables.WeatherTable;

@Getter
@Setter
@StorIOSQLiteType(table = WeatherTable.TABLE, generateTableClass = false)
public class WeatherSql {

    @StorIOSQLiteColumn(name = WeatherTable.COLUMN_ID, key = true)
    Long id;

    @StorIOSQLiteColumn(name = WeatherTable.COLUMN_NAME)
    String name;

    @StorIOSQLiteColumn(name = WeatherTable.COLUMN_DATE)
    String date;

    @StorIOSQLiteColumn(name = WeatherTable.COLUMN_JSON)
    String json;

    public WeatherSql() {
    }
}
