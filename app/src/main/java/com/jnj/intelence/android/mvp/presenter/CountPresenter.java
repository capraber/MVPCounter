package com.jnj.intelence.android.mvp.presenter;

import com.jnj.intelence.android.mvp.model.CountModel;
import com.jnj.intelence.android.mvp.view.CountView;
import com.squareup.otto.Subscribe;

import static com.jnj.intelence.android.mvp.view.CountView.*;
import static com.jnj.intelence.android.mvp.view.CountView.CountButtonPressedEvent;

public class CountPresenter {

    private CountModel model;
    private CountView view;

    public CountPresenter(CountModel model, CountView view) {
        this.model = model;
        this.view = view;
    }

    @Subscribe
    public void onCountButtonPressed(CountButtonPressedEvent event) {
        model.inc();
        view.setCount(String.valueOf(model.getCount()));
    }

    @Subscribe
    public void onResetButtonPressed(ResetButtonPressedEvent event) {
        model.reset();
        view.setCount(String.valueOf(model.getCount()));
    }
}
