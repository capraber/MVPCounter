package com.globant.counter.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.globant.counter.android.mvp.model.CountModel;
import com.globant.counter.android.mvp.presenter.CountPresenter;
import com.globant.counter.android.mvp.view.CountView;
import com.globant.counter.android.utils.BusProvider;


public class MainActivity extends AppCompatActivity {

    private CountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new CountPresenter(new CountModel(), new CountView(this, BusProvider.getInstance()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.register(presenter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.unregister(presenter);
    }
}
