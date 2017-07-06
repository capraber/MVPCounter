package com.globant.counter.android.mvp.view;


import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.globant.counter.android.R;
import com.globant.counter.android.utils.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountView extends ActivityView {


    @BindView(R.id.count_label)
    TextView countLabel;

    public CountView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setCount(String count) {
        countLabel.setText(count);
    }


    @OnClick({R.id.button_plus, R.id.button_mutliply, R.id.button_minus, R.id.button_divide})
    public void operButtonPressed(View view) {
        RxBus.post(new OperButtonPressedEvent(((Button) view).getText().toString()));
    }

    @OnClick({R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
            R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9})
    public void numButtonPressed(View view) {
        RxBus.post(new NumButtonPressedEvent(((Button) view).getText().toString()));
    }

    @OnClick(R.id.count_button)
    public void countButtonPressed() {
        RxBus.post(new CountButtonPressedEvent());
    }

    @OnClick(R.id.reset_button)
    public void resetButtonPressed() {
        RxBus.post(new ResetButtonPressedEvent());
    }

    @OnClick(R.id.button_equal)
    public void evalButtonPressed() {
        RxBus.post(new EvalButtonPressedEvent());
    }

}
