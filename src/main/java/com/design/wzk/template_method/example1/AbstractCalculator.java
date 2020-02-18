package com.design.wzk.template_method.example1;

public abstract class AbstractCalculator {

    /**
     * 主方法，实现对本类其他方法的调用
     * @param exp
     * @param opt
     * @return
     */
    public final int calculate(String exp,String opt){
        int array[] = split(exp,opt);
        return calculate(array[0],array[1]);
    }

    /**
     * 被子类重写的方法
     */
    abstract protected int calculate(int num1,int num2);

    private int[] split(String exp,String opt){
        String[] split = exp.split(opt);
        int[] intArray = new int[2];
        intArray[0] = Integer.parseInt(split[0]);
        intArray[1] = Integer.parseInt(split[1]);
        return intArray;
    }
}
