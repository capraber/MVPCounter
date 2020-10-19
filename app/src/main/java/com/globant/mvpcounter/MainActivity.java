package com.globant.mvpcounter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.globant.mvpcounter.databinding.ActivityMainBinding;
import com.globant.mvpcounter.mvp.model.CountModel;
import com.globant.mvpcounter.mvp.presenter.CountPresenter;
import com.globant.mvpcounter.mvp.view.CountView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CountPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new CountPresenter(new CountModel(), new CountView(this, binding));

        setListeners();
    }

    private void setListeners() {
        binding.countButton.setOnClickListener(view -> presenter.onCountButtonPressed());
        binding.resetButton.setOnClickListener(view -> presenter.onResetButtonPressed());
    }
}