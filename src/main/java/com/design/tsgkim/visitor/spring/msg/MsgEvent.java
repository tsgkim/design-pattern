package com.design.tsgkim.visitor.spring.msg;

import org.springframework.context.ApplicationEvent;

public class MsgEvent extends ApplicationEvent {

    private Msg msg;

    public MsgEvent(Object source) {
        super(source);
        this.msg = (Msg)source;
    }

    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }
}
