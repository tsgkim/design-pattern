package com.tsgkim.design.template_method.example1;

public class Plus extends AbstractCalculator {
    @Override
    public int calculate(int num1, int num2) {
        return num1+num2;
    }
}