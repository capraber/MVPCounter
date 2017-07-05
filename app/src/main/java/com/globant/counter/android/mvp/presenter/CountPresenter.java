package com.globant.counter.android.mvp.presenter;

import com.globant.counter.android.mvp.model.CountModel;
import com.globant.counter.android.mvp.view.CountView;
import com.globant.counter.android.utils.CountBusObserver;
import com.globant.counter.android.utils.ResetBusObserver;
import com.globant.counter.android.utils.RxBus;

import static com.globant.counter.android.mvp.view.CountView.CountButtonPressedEvent;
import static com.globant.counter.android.mvp.view.CountView.ResetButtonPressedEvent;

public class CountPresenter {

    private CountModel countModel;
    private CountView countView;

    public CountPresenter(CountModel model, CountView view) {
        this.countModel = model;
        this.countView = view;

        RxBus.subscribe(view, new CountBusObserver() {
            @Override
            public void onEvent(CountButtonPressedEvent value) {
                countModel.inc();
                countView.setCount(String.valueOf(countModel.getCount()));
            }
        });

        RxBus.subscribe(view,new ResetBusObserver() {
            @Override
            public void onEvent(ResetButtonPressedEvent value) {
                countModel.reset();
                countView.setCount(String.valueOf(countModel.getCount()));
            }
        });
    }


}
