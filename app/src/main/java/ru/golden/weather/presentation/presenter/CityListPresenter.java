package ru.golden.weather.presentation.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.gson.Gson;

import java.io.IOException;

import lombok.val;
import okhttp3.Response;
import ru.golden.weather.R;
import ru.golden.weather.model.dto.WeatherDto;
import ru.golden.weather.model.repository.CurrentWeatherRepository;
import ru.golden.weather.presentation.view.CityListView;

@InjectViewState
public class CityListPresenter extends MvpPresenter<CityListView> {

    private final CurrentWeatherRepository currentWeatherRepository;

    public CityListPresenter(final Context context) {
        currentWeatherRepository = new CurrentWeatherRepository(context);
    }

    public void getWeatherForCity(final String cityName) {
        currentWeatherRepository.loadCity(cityName)
                .subscribe(this::onCityLoadSuccess, this::onCityLoadFailed);
    }

    private void onCityLoadFailed(final Throwable throwable) {
        showCantGetDataError(throwable);
    }

    private void onCityLoadSuccess(final Response response) {
        val gson = new Gson();
        WeatherDto weather = null;

        try {
            if (response.body() != null) {
                weather = gson.fromJson(response.body().string(), WeatherDto.class);
            }
        } catch (final IOException e) {
            showCantGetDataError(e);
        }
    }

    private void showCantGetDataError(final Throwable throwable) {
        getViewState().showMessage(R.string.loading_city_fail_message);
    }
}
