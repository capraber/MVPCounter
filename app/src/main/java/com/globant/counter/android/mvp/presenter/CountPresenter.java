package com.globant.counter.android.mvp.presenter;

import com.globant.counter.android.mvp.model.CountModel;
import com.globant.counter.android.mvp.view.CountView;
import com.globant.counter.android.utils.CountBusObserver;
import com.globant.counter.android.utils.EvalBusObserver;
import com.globant.counter.android.utils.NumBusObserver;
import com.globant.counter.android.utils.OperBusObserver;
import com.globant.counter.android.utils.ResetBusObserver;
import com.globant.counter.android.utils.RxBus;

import static com.globant.counter.android.mvp.view.CountView.CountButtonPressedEvent;
import static com.globant.counter.android.mvp.view.CountView.ResetButtonPressedEvent;
import static com.globant.counter.android.mvp.view.CountView.OperButtonPressedEvent;
import static com.globant.counter.android.mvp.view.CountView.NumButtonPressedEvent;

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
                countView.setCount(String.valueOf(countModel.getFirstOperator()));
            }
        });

        RxBus.subscribe(view, new ResetBusObserver() {
            @Override
            public void onEvent(ResetButtonPressedEvent value) {
                countModel.reset();
                countView.setCount(String.valueOf(countModel.getFirstOperator()));
            }
        });
        RxBus.subscribe(view, new NumBusObserver() {
            @Override
            public void onEvent(NumButtonPressedEvent value) {
                countModel.write(value.getValue());
                countView.setCount(String.valueOf(countModel.getFirstOperator()));
            }
        });

        RxBus.subscribe(view, new OperBusObserver() {
            @Override
            public void onEvent(OperButtonPressedEvent value) {
                countModel.setOperator(value.getValue());
                countView.setCount(String.valueOf(countModel.getFirstOperator()));
            }
        });

        RxBus.subscribe(view, new EvalBusObserver() {
            @Override
            public void onEvent(CountView.EvalButtonPressedEvent value) {
                countView.setCount(String.valueOf(countModel.eval()));
            }
        });

    }


}
