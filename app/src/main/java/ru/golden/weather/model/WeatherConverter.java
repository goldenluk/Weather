package ru.golden.weather.model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
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
        weatherSql.setDate(new Date(weatherDto.getDt()).toString());

        return weatherSql;
    }

    public static List<WeatherDto> convertFromDbToDto(final List<WeatherSql> weatherSqls) {
        val newList = new ArrayList<WeatherDto>();
        val gson = new Gson();

        for (final WeatherSql weatherSql : weatherSqls) {
            newList.add(gson.fromJson(weatherSql.getJson(), WeatherDto.class));
        }

        return newList;
    }
}
