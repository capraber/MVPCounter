package com.globant.counter.android.mvp.view;


import android.app.Activity;
import android.widget.TextView;

import com.globant.counter.android.R;
import com.globant.counter.android.utils.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountView extends ActivityView {


    @BindView(R.id.count_label) TextView countLabel;

    public CountView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setCount(String count) {
        countLabel.setText(count);
    }

    @OnClick(R.id.count_button)
    public void countButtonPressed() {
        RxBus.post(new CountButtonPressedEvent());
    }

    @OnClick(R.id.reset_button)
    public void resetButtonPressed() {
        RxBus.post(new ResetButtonPressedEvent());
    }

    public static class CountButtonPressedEvent {
        // nothing to do.
    }

    public static class ResetButtonPressedEvent {
        // nothing to do.
    }
}
