package com.globant.counter.android.utils;

import com.globant.counter.android.mvp.view.ActivityView;

/**
 * Created by mauriciovignale on 04/07/17.
 */
public abstract class CountBusObserver extends BusObserver<ActivityView.CountButtonPressedEvent>{

    protected CountBusObserver() {
        super(ActivityView.CountButtonPressedEvent.class);
    }
}
