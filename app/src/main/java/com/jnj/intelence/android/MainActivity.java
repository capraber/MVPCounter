package com.jnj.intelence.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jnj.intelence.android.mvp.model.CountModel;
import com.jnj.intelence.android.mvp.presenter.CountPresenter;
import com.jnj.intelence.android.mvp.view.CountView;
import com.jnj.intelence.android.utils.BusProvider;


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
