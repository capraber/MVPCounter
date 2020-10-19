package com.globant.mvpcounter.mvp.presenter;

import com.globant.mvpcounter.mvp.model.CountModel;
import com.globant.mvpcounter.mvp.view.CountView;

public class CountPresenter {

    private CountModel model;
    private CountView view;

    public CountPresenter(CountModel model, CountView view) {
        this.model = model;
        this.view = view;
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
