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

    private List<WeatherDto> citiesWeather;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(final View v) {
            super(v);
            textView = (TextView) v;
        }
    }

    public WeatherListAdapter(final List<WeatherDto> citiesWeather) {
        this.citiesWeather = citiesWeather;
    }

    @Override
    public WeatherListAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_city_list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return citiesWeather.size();
    }
}
