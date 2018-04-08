package ru.golden.weather.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import lombok.val;
import ru.golden.weather.R;
import ru.golden.weather.presentation.presenter.AddCityPresenter;
import ru.golden.weather.presentation.view.AddCityView;


public class AddCityActivity extends BaseActivity implements AddCityView {

    @InjectPresenter
    AddCityPresenter addCityPresenter;

    @ProvidePresenter
    AddCityPresenter provideAddCityPresenter() {
        return new AddCityPresenter(getApplicationContext());
    }

    @BindView(R.id.city_name_edit_text)
    EditText cityNameEditText;

    @BindView(R.id.toolbar_add_city)
    Toolbar toolbar;

    @BindView(R.id.find_button)
    Button findButton;

    @BindView(R.id.progress_loading_adding_city)
    ProgressBar progressBar;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        ButterKnife.bind(this);

        progressBar.setVisibility(View.GONE);
        setSupportActionBar(toolbar);

        val supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @OnClick(R.id.find_button)
    public void onFindButtonClick() {
        progressBar.setVisibility(View.VISIBLE);
        findButton.setEnabled(false);
        addCityPresenter.findAndTryAddCity(cityNameEditText.getText().toString());
    }

    @Override
    public void finishWithOk() {
        stopProgress();
        showMessage(R.string.city_finded);
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void stopProgress() {
        progressBar.setVisibility(View.GONE);
        findButton.setEnabled(true);
    }
}
