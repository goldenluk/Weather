package ru.golden.weather.model;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.val;
import ru.golden.weather.model.db.entities.WeatherSql;
import ru.golden.weather.model.dto.WeatherDto;

public class WeatherConverter {

    public static WeatherSql convertFromDtoToDb(final WeatherDto weatherDto) {
        val gson = new Gson();

        val weatherSql = new WeatherSql();
        weatherSql.setJson(gson.toJson(weatherDto));
        weatherSql.setName(weatherDto.getName());

        val df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        val today = Calendar.getInstance().getTime();
        val date = df.format(today);

        weatherSql.setDate(date);

        return weatherSql;
    }

    public static List<WeatherDto> convertFromDbToDto(final List<WeatherSql> weatherSqls) {
        val newList = new ArrayList<WeatherDto>();
        val gson = new Gson();

        for (final WeatherSql weatherSql : weatherSqls) {
            val weather = gson.fromJson(weatherSql.getJson(), WeatherDto.class);
            weather.setLastUpdate(weatherSql.getDate());
            newList.add(weather);
        }

        return newList;
    }
}
