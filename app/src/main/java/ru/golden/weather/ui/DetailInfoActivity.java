package ru.golden.weather.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.val;
import ru.golden.weather.R;
import ru.golden.weather.model.dto.WeatherDto;

public class DetailInfoActivity extends AppCompatActivity {

    public static final String DETAILS_EXTRA = "details_extra";

    @BindView(R.id.toolbar_details)
    Toolbar toolbar;

    @BindView(R.id.detail_info_city_name)
    TextView cityNameTextView;

    @BindView(R.id.detail_info_description)
    TextView descriptionTextView;

    @BindView(R.id.detail_info_pressure)
    TextView pressureTextView;

    @BindView(R.id.detail_info_humidity)
    TextView humidityTextView;

    @BindView(R.id.detail_info_wind_speed)
    TextView windTextView;

    @BindView(R.id.detail_info_cloudiness)
    TextView cloudTextView;

    @BindView(R.id.detail_info_country_code)
    TextView countryTextView;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_info);

        val info = (WeatherDto) getIntent().getSerializableExtra(DETAILS_EXTRA);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        val actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }

        if (info != null) {
            initFields(info);
        }
    }

    private void initFields(final WeatherDto info) {
        cityNameTextView.setText(info.getName());
        descriptionTextView.setText(getString(R.string.detail_description, info.getWeather().get(0).getDescription()));
        pressureTextView.setText(getString(R.string.pressure_value, String.valueOf(info.getMain().getPressure())));
        humidityTextView.setText(getString(R.string.humidity_value, String.valueOf(info.getMain().getHumidity())));
        windTextView.setText(getString(R.string.wind_speed, String.valueOf(info.getWind().getSpeed())));
        cloudTextView.setText(getString(R.string.cloudiness_value, String.valueOf(info.getClouds().getAll())));
        countryTextView.setText(getString(R.string.country_code_value, String.valueOf(info.getSys().getCountry())));
    }
}
