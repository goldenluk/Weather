package ru.golden.weather.presentation.view;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ru.golden.weather.model.dto.WeatherDto;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface CityListView extends BaseView {

    /**
     * Updating city list
     */
    void updateCityList(final List<WeatherDto> cities);

    void updateCityList();
}
