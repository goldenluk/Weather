package ru.golden.weather.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

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

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        val supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @OnClick(R.id.find_button)
    public void onFindButtonClick() {
        addCityPresenter.findAndTryAddCity(cityNameEditText.getText().toString());
    }

    @Override
    public void finishWithOk() {
        showMessage(R.string.city_finded);
        setResult(RESULT_OK);
        finish();
    }
}
