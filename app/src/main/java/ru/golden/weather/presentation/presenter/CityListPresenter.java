package ru.golden.weather.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.gson.Gson;

import java.io.IOException;

import lombok.val;
import okhttp3.Response;
import ru.golden.weather.model.dto.WeatherDto;
import ru.golden.weather.model.repository.CurrentWeatherRepository;
import ru.golden.weather.presentation.view.CityListView;

@InjectViewState
public class CityListPresenter extends MvpPresenter<CityListView> {

    private final CurrentWeatherRepository currentWeatherRepository = new CurrentWeatherRepository();

    public CityListPresenter() {
        getViewState().showMessage("Hello");
    }

    public void getWeatherForCity(final String cityName) {
        currentWeatherRepository.loadCity(cityName)
                .subscribe(this::onCityLoadSuccess, this::onCityLoadFailed);
    }

    private void onCityLoadFailed(final Throwable throwable) {
       //TODO логи
        getViewState().showMessage("Fail");
    }

    private void onCityLoadSuccess(final Response response) {
        val gson = new Gson();
        try {
            val weather = gson.fromJson(response.body().string(), WeatherDto.class);
            val name = weather.getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
