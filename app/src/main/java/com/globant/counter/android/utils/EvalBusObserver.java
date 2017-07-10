package com.globant.counter.android.utils;

import com.globant.counter.android.mvp.view.ActivityView;

/**
 * Created by mauriciovignale on 04/07/17.
 */
public abstract class EvalBusObserver extends BusObserver<ActivityView.EvalButtonPressedEvent>{

    protected EvalBusObserver() {
        super(ActivityView.EvalButtonPressedEvent.class);
    }
}
