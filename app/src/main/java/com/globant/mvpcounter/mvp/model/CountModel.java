package com.globant.mvpcounter.mvp.model;

import com.globant.mvpcounter.mvp.contract.CountContract;

public class CountModel implements CountContract.Model {

    private int count = 0;

    @Override
    public void reset() {
        count = 0;
    }

    @Override
    public void inc() {
        count += 1;
    }

    @Override
    public int getCount() {
        return count;
    }

}
