package ru.golden.weather.presentation.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import ru.golden.weather.R;
import ru.golden.weather.model.dto.WeatherDto;
import ru.golden.weather.model.repository.CurrentWeatherRepository;
import ru.golden.weather.presentation.view.CityListView;

@InjectViewState
public class CityListPresenter extends MvpPresenter<CityListView> {

    private static final String DEFAULT_CITY = "Moscow, RU";
    private static final String DEFAULT_CITY_2 = "saint petersburg, RU";

    private final CurrentWeatherRepository currentWeatherRepository;

    public CityListPresenter(final Context context) {
        currentWeatherRepository = new CurrentWeatherRepository(context);
    }

    public void getWeatherForCity(final String cityName) {
        currentWeatherRepository.loadCity(cityName)
                .map(currentWeatherRepository::createDtoFromResponse)
                .subscribe(this::onCityLoadSuccess, this::onCityLoadFailed);
    }

    private void onCityLoadFailed(final Throwable throwable) {
        showCantGetDataError(throwable);
    }

    private void onCityLoadSuccess(final WeatherDto weather) {
        if (weather == null) {
            showCantGetDataError(new Throwable());
            return;
        }

        currentWeatherRepository.saveCityToDb(weather)
                .subscribe(result -> initList());
    }

    private void showCantGetDataError(final Throwable throwable) {
        getViewState().stopProgress();
        getViewState().showMessage(R.string.loading_city_fail_message);
    }

    public void initList() {
        currentWeatherRepository.getAllCitiesFromDb()
                .subscribe(this::onGetFromDbSuccess);
    }

    private void onGetFromDbSuccess(final List<WeatherDto> weatherDtos) {
        if (weatherDtos.isEmpty()) {
            initDefaultCities();
        } else {
            getViewState().updateCityList(weatherDtos);
        }
    }

    private void initDefaultCities() {
        getWeatherForCity(DEFAULT_CITY);
        getWeatherForCity(DEFAULT_CITY_2);
    }

    public void deleteCity(final String cityName) {
        currentWeatherRepository.deleteCity(cityName)
                .subscribe(result -> onCityDeleted());
    }

    private void onCityDeleted() {
        getViewState().showMessage(R.string.city_deleted);
        getViewState().updateCityList();
    }
}
