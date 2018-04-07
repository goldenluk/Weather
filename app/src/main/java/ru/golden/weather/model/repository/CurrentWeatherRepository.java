package ru.golden.weather.model.repository;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Response;
import ru.golden.weather.model.ResponseFactory;
import ru.golden.weather.model.URLCreator;

public class CurrentWeatherRepository {

    public Single<Response> loadCity(final String cityName) {
        //TODO добавить map с сохранением в базу
        return Single.just(cityName)
                .map(name -> ResponseFactory.getResponse(URLCreator.getCurrentWeatherUrl(name)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
