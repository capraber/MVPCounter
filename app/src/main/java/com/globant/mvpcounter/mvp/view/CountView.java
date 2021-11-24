package com.globant.mvpcounter.mvp.view;

import android.app.Activity;

import com.globant.mvpcounter.databinding.ActivityMainBinding;
import com.globant.mvpcounter.mvp.contract.CountContract;
import com.globant.mvpcounter.mvp.view.base.ActivityView;

public class CountView extends ActivityView implements CountContract.View {

    private final ActivityMainBinding binding;

    public CountView(Activity activity) {
        super(activity);

        binding = ActivityMainBinding.inflate(activity.getLayoutInflater());
        activity.setContentView(binding.getRoot());
    }

    @Override
    public void setCount(String count) {
        binding.countLabel.setText(count);
    }

    @Override
    public void onCountButtonPressed(Runnable onClick) {
        binding.countButton.setOnClickListener(v -> onClick.run());
    }

    @Override
    public void onResetButtonPressed(Runnable onClick) {
        binding.resetButton.setOnClickListener(v -> onClick.run());
    }
}
