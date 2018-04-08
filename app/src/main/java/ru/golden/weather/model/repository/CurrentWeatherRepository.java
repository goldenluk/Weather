package ru.golden.weather.model.repository;

import android.content.Context;

import com.pushtorefresh.storio3.sqlite.operations.put.PutResult;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;
import ru.golden.weather.model.ResponseFactory;
import ru.golden.weather.model.URLCreator;
import ru.golden.weather.model.WeatherConverter;
import ru.golden.weather.model.ds.WeatherListDataSource;
import ru.golden.weather.model.dto.WeatherDto;

public class CurrentWeatherRepository {

    private final WeatherListDataSource dataSource;

    public CurrentWeatherRepository(final Context context) {
        dataSource = new WeatherListDataSource(context);
    }

    public Single<Response> loadCity(final String cityName) {
        return Single.just(cityName)
                .map(name -> ResponseFactory.getResponse(URLCreator.getCurrentWeatherUrl(name)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<PutResult> saveCityToDb(final WeatherDto weatherDto) {
        return Single.just(weatherDto)
                .map(WeatherConverter::convertFromDtoToDb)
                .map(dataSource::storeCityWeather)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<WeatherDto>> getAllCitiesFromDb() {
        return Single.just(dataSource.getAllCitiesWeather())
                .map(WeatherConverter::convertFromDbToDto)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
