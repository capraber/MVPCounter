package com.globant.counter.android.utils;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.globant.counter.android.mvp.view.ActivityView;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by mauriciovignale on 03/07/17.
 */

public class RxBus {
    private static Map<ActivityView, CompositeDisposable> disposableMap = new HashMap<>();
    private static PublishSubject<Object> publishSubject = PublishSubject.create();

    private RxBus() {
        // Nothing
    }

    public static void post(@NonNull Object object) {
        publishSubject.onNext(object);
    }

    @SuppressWarnings("unchecked")
    public static void subscribe(@NonNull ActivityView key, @NonNull BusObserver busObserver) {
        CompositeDisposable compositeDisposable = disposableMap.get(key);
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(publishSubject.subscribe(busObserver));
        disposableMap.put(key, compositeDisposable);
    }

    public static void clear(@NonNull Activity key) {
        CompositeDisposable compositeDisposable = disposableMap.get(key);
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
        disposableMap.remove(key);
    }

    public static void clearAll() {
        for (Map.Entry<ActivityView, CompositeDisposable> entry : disposableMap.entrySet()) {
            entry.getValue().clear();
        }
        disposableMap.clear();
    }
}
