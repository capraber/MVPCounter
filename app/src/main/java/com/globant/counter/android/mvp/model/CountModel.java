package com.globant.counter.android.mvp.model;

public class CountModel {

    private int firstOperator = 0;
    private int memory = 0;
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
        memory = firstOperator;
        reset();
    }
    public int eval(){
        if (operator !=null){
            switch (operator){
                case "+": firstOperator = memory + firstOperator;
                    break;
                case "-": firstOperator = memory - firstOperator;
                    break;
                case "*": firstOperator = memory * firstOperator;
                    break;
                case "/": firstOperator = memory / firstOperator;
                    break;
                default: firstOperator = 0;
            }
        }
        operator = null;
        return firstOperator;
    }
}
