package ru.golden.weather.model.ds;

import android.content.Context;

import com.pushtorefresh.storio3.sqlite.StorIOSQLite;
import com.pushtorefresh.storio3.sqlite.impl.DefaultStorIOSQLite;
import com.pushtorefresh.storio3.sqlite.operations.delete.DeleteResult;
import com.pushtorefresh.storio3.sqlite.operations.put.PutResult;
import com.pushtorefresh.storio3.sqlite.queries.DeleteQuery;
import com.pushtorefresh.storio3.sqlite.queries.Query;

import java.util.List;

import ru.golden.weather.model.db.WeatherDbHelper;
import ru.golden.weather.model.db.entities.WeatherSql;
import ru.golden.weather.model.db.entities.WeatherSqlSQLiteTypeMapping;
import ru.golden.weather.model.db.tables.WeatherTable;

public class WeatherListDataSource {

    private final StorIOSQLite storIOSQLite;

    public WeatherListDataSource(final Context context) {
        storIOSQLite = DefaultStorIOSQLite.builder()
                .sqliteOpenHelper(new WeatherDbHelper(context))
                .addTypeMapping(WeatherSql.class, new WeatherSqlSQLiteTypeMapping())
                .build();
    }

    public PutResult storeCityWeather(final WeatherSql weatherSql) {
        deleteCity(weatherSql.getName());

        return storIOSQLite
                .put()
                .object(weatherSql)
                .prepare()
                .executeAsBlocking();
    }

    public List<WeatherSql> getAllCitiesWeather() {
        return storIOSQLite
                .get()
                .listOfObjects(WeatherSql.class)
                .withQuery(Query.builder().table(WeatherTable.TABLE).build())
                .prepare()
                .executeAsBlocking();
    }

    public DeleteResult deleteCity(final String cityName) {
        return storIOSQLite
                .delete()
                .byQuery(DeleteQuery.builder()
                        .table(WeatherTable.TABLE)
                        .where(WeatherTable.COLUMN_NAME + " = ?")
                        .whereArgs(cityName)
                        .build())
                .prepare()
                .executeAsBlocking();
    }
}
