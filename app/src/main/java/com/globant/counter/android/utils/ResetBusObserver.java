package com.globant.counter.android.utils;

import com.globant.counter.android.mvp.view.CountView;

/**
 * Created by mauriciovignale on 04/07/17.
 */
public abstract class ResetBusObserver extends BusObserver<CountView.ResetButtonPressedEvent>{

    protected ResetBusObserver() {
        super(CountView.ResetButtonPressedEvent.class);
    }
}
