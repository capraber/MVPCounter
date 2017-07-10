package com.globant.counter.android.utils;

import com.globant.counter.android.mvp.view.ActivityView;

/**
 * Created by mauriciovignale on 04/07/17.
 */
public abstract class ResetBusObserver extends BusObserver<ActivityView.ResetButtonPressedEvent>{

    protected ResetBusObserver() {
        super(ActivityView.ResetButtonPressedEvent.class);
    }
}
