package com.globant.counter.android.utils;

import com.globant.counter.android.mvp.view.ActivityView;

/**
 * Created by mauriciovignale on 04/07/17.
 */
public abstract class NumBusObserver extends BusObserver<ActivityView.NumButtonPressedEvent>{

    protected NumBusObserver() {
        super(ActivityView.NumButtonPressedEvent.class);
    }
}
