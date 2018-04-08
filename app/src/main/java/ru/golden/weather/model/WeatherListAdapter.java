package ru.golden.weather.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import lombok.val;
import ru.golden.weather.R;
import ru.golden.weather.model.dto.WeatherDto;
import ru.golden.weather.ui.CityListActivity;
import ru.golden.weather.ui.DetailInfoActivity;

public class WeatherListAdapter extends RecyclerView.Adapter<WeatherListAdapter.ViewHolder> {

    private static final double kelvin = 273.15;

    private final List<WeatherDto> citiesWeather;
    private final Context context;

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final View citiesWeatherView;

        ViewHolder(final View v) {
            super(v);
            citiesWeatherView = v;
        }
    }

    public WeatherListAdapter(final List<WeatherDto> citiesWeather, final Context context) {
        this.citiesWeather = citiesWeather;
        this.context = context;
    }

    @Override
    public WeatherListAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_weather_card, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        val weatherItem = citiesWeather.get(position);

        final TextView cityName = holder.citiesWeatherView.findViewById(R.id.city_name);
        cityName.setText(weatherItem.getName());

        final TextView currentWeather = holder.citiesWeatherView.findViewById(R.id.current_weather);
        currentWeather.setText(holder.citiesWeatherView.getContext()
                .getString(R.string.current_temp, String.valueOf(weatherItem.getMain().getTemp() - kelvin).substring(0, 5)));

        final TextView lastUpdateTime = holder.citiesWeatherView.findViewById(R.id.last_update_time);
        lastUpdateTime.setText(context.getString(R.string.last_update_time, weatherItem.getLastUpdate()));

        final Button deleteButton = holder.citiesWeatherView.findViewById(R.id.delete_city_button);
        deleteButton.setOnClickListener(view -> {
            if (context instanceof CityListActivity) {
                ((CityListActivity) context).deleteCity(weatherItem.getName());
            }
        });

        final Button updateButton = holder.citiesWeatherView.findViewById(R.id.update_city_button);
        updateButton.setOnClickListener(view -> {
            if (context instanceof CityListActivity) {
                ((CityListActivity) context).updateCity(weatherItem.getName());
            }
        });

        final Button moreInfoButton = holder.citiesWeatherView.findViewById(R.id.detail_weather_info_button);
        moreInfoButton.setOnClickListener(view -> {
            val detailIntent = new Intent(context, DetailInfoActivity.class);
            detailIntent.putExtra(DetailInfoActivity.DETAILS_EXTRA, weatherItem);
            context.startActivity(detailIntent);
        });
    }

    @Override
    public int getItemCount() {
        return citiesWeather.size();
    }
}
