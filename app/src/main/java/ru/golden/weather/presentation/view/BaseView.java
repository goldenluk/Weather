package ru.golden.weather.presentation.view;

import com.arellomobile.mvp.MvpView;

public interface BaseView extends MvpView {

    /**
     * Showing message
     *
     * @param messageId resource`s id
     */
    void showMessage(final int messageId);

    /**
     * Showing message
     */
    void showMessage(final String message);
}
