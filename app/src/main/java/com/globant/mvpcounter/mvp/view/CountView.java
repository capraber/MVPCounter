package com.globant.mvpcounter.mvp.view;

import android.app.Activity;

import com.globant.mvpcounter.databinding.ActivityMainBinding;

public class CountView extends ActivityView {

    private final ActivityMainBinding binding;

    public CountView(Activity activity, ActivityMainBinding binding) {
        super(activity);
        this.binding = binding;
    }

    public void setCount(String count) {
        binding.countLabel.setText(count);
    }
}
