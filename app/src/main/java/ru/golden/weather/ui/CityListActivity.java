package ru.golden.weather.ui;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.BindView;
import ru.golden.weather.R;
import ru.golden.weather.model.dto.WeatherDto;
import ru.golden.weather.presentation.presenter.CityListPresenter;
import ru.golden.weather.presentation.view.CityListView;

public class CityListActivity extends MvpAppCompatActivity implements CityListView {

    @InjectPresenter
    CityListPresenter cityListPresenter;

    @ProvidePresenter
    CityListPresenter provideCityListPresenter() {
        return new CityListPresenter(getApplicationContext());
    }

    @BindView(R.id.weather_recycler_view)
    RecyclerView weatherCityList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        cityListPresenter.getWeatherForCity("Omsk");
    }

    @Override
    public void showMessage(final int messageId) {
        Toast.makeText(this, getString(messageId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateCityList(final List<WeatherDto> cities) {

    }
}
