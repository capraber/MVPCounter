package com.globant.counter.android.mvp.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

public class ActivityView {
    private WeakReference<Activity> activityRef;

    public ActivityView(Activity activity) {
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public Activity getActivity() {
        return activityRef.get();
    }

    @Nullable
    public Context getContext() {
        return getActivity();
    }

    @Nullable
    public FragmentManager getFragmentManager() {
        Activity activity = getActivity();
        return (activity != null) ? activity.getFragmentManager() : null;
    }

    public static class CountButtonPressedEvent {
        // nothing to do.
    }

    public static class ResetButtonPressedEvent {
        // nothing to do.
    }

    public static class EvalButtonPressedEvent {
        // nothing to do.
    }

    public static class NumButtonPressedEvent {
        private Integer value;

        NumButtonPressedEvent(String s) {
            this.value = Integer.parseInt(s);
        }

        public Integer getValue() {
            return value;
        }
    }

    public static class OperButtonPressedEvent {
        private String value;

        OperButtonPressedEvent(String s) {
            this.value = s;
        }

        public String getValue() {
            return value;
        }
    }
}
