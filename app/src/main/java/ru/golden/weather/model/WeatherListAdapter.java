package ru.golden.weather.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.golden.weather.R;
import ru.golden.weather.model.dto.WeatherDto;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder> {

    private static final double kelvin = 273.15;

    private List<WeatherDto> citiesWeather;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final View citiesWeatherView;

        ViewHolder(final View v) {
            super(v);
            citiesWeatherView = v;
        }
    }

    public WeatherListAdapter(final List<WeatherDto> citiesWeather) {
        this.citiesWeather = citiesWeather;
    }

    @Override
    public WeatherListAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_weather_card, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final WeatherDto weatherItem = citiesWeather.get(position);

        final TextView cityName = holder.citiesWeatherView.findViewById(R.id.city_name);
        cityName.setText(weatherItem.getName());

        final TextView currentWeather = holder.citiesWeatherView.findViewById(R.id.current_weather);
        currentWeather.setText(holder.citiesWeatherView.getContext()
                .getString(R.string.current_temp, String.valueOf(weatherItem.getMain().getTemp() - kelvin).substring(0, 5)));

        //TODO Кнопка подробности
    }

    @Override
    public int getItemCount() {
        return citiesWeather.size();
    }
}
