package com.globant.mvpcounter.mvp.presenter;

import com.globant.mvpcounter.mvp.contract.CountContract;

public class CountPresenter implements CountContract.Presenter {

    private final CountContract.Model model;
    private final CountContract.View view;

    public CountPresenter(CountContract.Model model, CountContract.View view) {
        this.model = model;
        this.view = view;

        this.view.onCountButtonPressed(this::onCountButtonPressed);
        this.view.onResetButtonPressed(this::onResetButtonPressed);
    }

    public void onCountButtonPressed() {
        model.inc();
        view.setCount(String.valueOf(model.getCount()));
    }

    public void onResetButtonPressed() {
        model.reset();
        view.setCount(String.valueOf(model.getCount()));
    }
}
