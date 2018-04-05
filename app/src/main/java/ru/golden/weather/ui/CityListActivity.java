package ru.golden.weather.ui;

import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.golden.weather.R;
import ru.golden.weather.presentation.presenter.CityListPresenter;
import ru.golden.weather.presentation.view.CityListView;

public class CityListActivity extends MvpAppCompatActivity implements CityListView {

    @InjectPresenter
    CityListPresenter cityListPresenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
    }

    @Override
    public void showMessage(final int messageId) {
        Toast.makeText(this, getString(messageId), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
