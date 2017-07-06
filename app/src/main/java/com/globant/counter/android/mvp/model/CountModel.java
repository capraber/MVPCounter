package com.globant.counter.android.mvp.model;

public class CountModel {

    private int firstOperator = 0;
    private int secondOperator = 0;
    private String operator = null;

    public void reset() {
        firstOperator = 0;
    }

    public void inc() {
        firstOperator += 1;
    }

    public void write(int digit){
        firstOperator = firstOperator * 10 + digit;
    }

    public int getFirstOperator() {
        return firstOperator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
        secondOperator = firstOperator;
        reset();
    }
    public int eval(){
        int ret;
        switch (operator){
            case "+": ret = secondOperator + firstOperator;
                        break;
            case "-": ret = secondOperator - firstOperator;
                        break;
            case "*": ret = secondOperator * firstOperator;
                        break;
            case "/": ret = secondOperator / firstOperator;
                        break;
            default: ret = 0;
        }
        reset();
        operator = null;
        return ret;
    }
}
