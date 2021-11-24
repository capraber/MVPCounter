package com.globant.mvpcounter.mvp.contract;

public interface CountContract {

    interface Model {
        void reset();
        void inc();
        int getCount();
    }

    interface View {
        void setCount(String count);
        void onCountButtonPressed(Runnable onClick);
        void onResetButtonPressed(Runnable onClick);
    }

    interface Presenter {
        void onCountButtonPressed();
        void onResetButtonPressed();
    }
}
