package ru.golden.weather.presentation.presenter;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.golden.weather.R;
import ru.golden.weather.model.dto.WeatherDto;
import ru.golden.weather.model.repository.CurrentWeatherRepository;
import ru.golden.weather.presentation.view.AddCityView;

@InjectViewState
public class AddCityPresenter extends MvpPresenter<AddCityView> {

    private final CurrentWeatherRepository currentWeatherRepository;

    public AddCityPresenter(final Context context) {
        currentWeatherRepository = new CurrentWeatherRepository(context);
    }

    public void findAndTryAddCity(final String cityName) {
        currentWeatherRepository.loadCity(cityName)
                .map(currentWeatherRepository::checkResponseAndReturnWeatherIfItExist)
                .subscribe(this::onSuccessGetConnection, this::onCityFindFailed);
    }

    private void onCityFindFailed(final Throwable throwable) {
        getViewState().stopProgress();
        getViewState().showMessage(R.string.bad_find);
    }

    private void onSuccessGetConnection(final WeatherDto weatherDto) {
        if (weatherDto == null) {
            getViewState().showMessage(R.string.bad_find);
            return;
        }

        currentWeatherRepository.saveCityToDb(weatherDto)
                //Here no onError, because if we have troubles with db, we cant work
                .subscribe(result -> onSuccessCityAdd());
    }

    private void onSuccessCityAdd() {
        getViewState().finishWithOk();
    }
}
