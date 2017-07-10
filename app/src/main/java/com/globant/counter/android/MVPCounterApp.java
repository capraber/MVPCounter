package com.globant.counter.android;

import android.app.Application;

import com.globant.counter.android.utils.RxBus;

/**
 * Created by mauriciovignale on 05/07/17.
 */

public class MVPCounterApp extends Application {

    @Override
    public void onTerminate() {
        super.onTerminate();
        RxBus.clearAll();

    }
}
