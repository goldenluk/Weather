package ru.golden.weather.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.golden.weather.R;
import ru.golden.weather.model.WeatherListAdapter;
import ru.golden.weather.model.dto.WeatherDto;
import ru.golden.weather.presentation.presenter.CityListPresenter;
import ru.golden.weather.presentation.view.CityListView;

public class CityListActivity extends BaseActivity implements CityListView {

    private static final int FIND_CITY_REQUEST_CODE = 111;

    @InjectPresenter
    CityListPresenter cityListPresenter;

    @ProvidePresenter
    CityListPresenter provideCityListPresenter() {
        return new CityListPresenter(getApplicationContext());
    }

    @BindView(R.id.weather_recycler_view)
    RecyclerView weatherCityList;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.progress_loading)
    ProgressBar progressBar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        weatherCityList.setLayoutManager(new LinearLayoutManager(this));

        cityListPresenter.initList();
    }

    @Override
    public void updateCityList(final List<WeatherDto> cities) {
        progressBar.setVisibility(View.GONE);
        //it should be improved
        weatherCityList.setAdapter(new WeatherListAdapter(cities, this));
    }

    @Override
    public void updateCityList() {
        progressBar.setVisibility(View.VISIBLE);
        cityListPresenter.initList();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                startActivityForResult(new Intent(this, AddCityActivity.class), FIND_CITY_REQUEST_CODE);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (requestCode == FIND_CITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                cityListPresenter.initList();
            }
        }
    }

    @Override
    public void stopProgress() {
        progressBar.setVisibility(View.GONE);
    }

    public void deleteCity(final String cityName) {
        progressBar.setVisibility(View.VISIBLE);
        cityListPresenter.deleteCity(cityName);
    }

    public void updateCity(final String cityName) {
        progressBar.setVisibility(View.VISIBLE);
        cityListPresenter.getWeatherForCity(cityName);
    }
}
