package ru.golden.weather.presentation.view;

import java.util.List;

import ru.golden.weather.model.dto.WeatherDto;

public interface CityListView extends BaseView {

    /**
     * Updating city list
     */
    void updateCityList(final List<WeatherDto> cities);
}
