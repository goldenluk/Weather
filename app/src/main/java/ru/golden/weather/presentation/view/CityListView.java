package ru.golden.weather.presentation.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ru.golden.weather.model.dto.WeatherDto;

public interface CityListView extends MvpView {

    /**
     * Showing message
     *
     * @param messageId resource`s id
     */
    void showMessage(final int messageId);

    /**
     * Showing message
     */
    void showMessage(final String message);

    /**
     * Updating city list
     */
    void updateCityList(final List<WeatherDto> cities);
}
