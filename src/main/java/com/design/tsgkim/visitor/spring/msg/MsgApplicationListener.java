package com.design.tsgkim.visitor.spring.msg;

import org.springframework.context.ApplicationListener;

public interface MsgApplicationListener extends ApplicationListener<MsgEvent> {

    void onExecute(Msg msg);

    void onSuccess(Msg msg);

    void onError(Msg msg);

}
