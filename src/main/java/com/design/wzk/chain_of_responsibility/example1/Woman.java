package com.design.chain_of_responsibility.example1;

public class Woman implements IWoman {

    private int type = 0;
    private String request = "";
    public Woman(int type,String request){
        this.type = type;
        this.request = request;
    }
    public int getType() {
        return type;
    }

    public String getRequest() {
        return request;
    }
}
