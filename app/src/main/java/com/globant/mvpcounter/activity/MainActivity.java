package com.globant.mvpcounter.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.globant.mvpcounter.mvp.model.CountModel;
import com.globant.mvpcounter.mvp.presenter.CountPresenter;
import com.globant.mvpcounter.mvp.view.CountView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new CountPresenter(new CountModel(), new CountView(this));
    }
}
