package com.design.tsgkim.proxy.aop;

public class PointCut {

    private String classNamePattern;

    private String methodNamePattern;

    public String getClassNamePattern() {
        return classNamePattern;
    }

    public void setClassNamePattern(String classNamePattern) {
        this.classNamePattern = classNamePattern;
    }

    public String getMethodNamePattern() {
        return methodNamePattern;
    }

    public void setMethodNamePattern(String methodNamePattern) {
        this.methodNamePattern = methodNamePattern;
    }

}
