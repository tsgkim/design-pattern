package com.design.wzk.template_method.example1;

public class Test {
    public static void main(String[] args) {
        String exp = "8+8";
        AbstractCalculator cal = new Plus();
        int result = cal.calculate(exp,"\\+");
        System.out.println(result);
    }
}
