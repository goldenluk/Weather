package ru.golden.weather.ui;

import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;

import ru.golden.weather.presentation.view.BaseView;


public abstract class BaseActivity extends MvpAppCompatActivity implements BaseView {

    @Override
    public void showMessage(final int messageId) {
        Toast.makeText(this, getString(messageId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
