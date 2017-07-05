package com.globant.counter.android.utils;

import com.globant.counter.android.mvp.view.CountView;

import io.reactivex.functions.Consumer;

/**
 * Created by mauriciovignale on 04/07/17.
 */
public abstract class CountBusObserver extends BusObserver<CountView.CountButtonPressedEvent>{

    protected CountBusObserver() {
        super(CountView.CountButtonPressedEvent.class);
    }
}
