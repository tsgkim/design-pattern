package com.design.tsgkim.visitor.spring.msg;

import org.springframework.stereotype.Component;

@Component
public class SmsListener implements MsgApplicationListener {

    @Override
    public void onApplicationEvent(MsgEvent msgEvent) {

        onExecute(msgEvent.getMsg());

    }

    @Override
    public void onExecute(Msg msg) {

        System.out.println("发送短息消息，配置信息为: " + msg.toString());

        onSuccess(msg);

    }

    @Override
    public void onSuccess(Msg msg) {
        System.out.println("成功发送短息消息，配置信息为: " + msg.toString());
    }

    @Override
    public void onError(Msg msg) {
        System.out.println("成功发送短息消息，配置信息为: " + msg.toString());
    }

}
