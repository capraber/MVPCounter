package com.globant.counter.android.utils;

import io.reactivex.functions.Consumer;

/**
 * Created by mauriciovignale on 04/07/17.
 */
public abstract class BusObserver<T> implements Consumer<Object> {
    private final Class<T> clazz;

    public BusObserver(Class<T> clazz) {
        this.clazz = clazz;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void accept(Object value) throws Exception {
        if (value.getClass() == clazz) {
            onEvent((T) value);
        }
    }

    public abstract void onEvent(T value);
}
