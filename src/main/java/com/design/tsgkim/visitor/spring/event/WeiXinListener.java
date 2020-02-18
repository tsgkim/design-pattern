package com.design.tsgkim.visitor.spring.event;

import com.design.tsgkim.visitor.spring.po.Msg;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class WeiXinListener implements MsgApplicationListener {

    @Async
    @Override
    public void onApplicationEvent(MsgEvent msgEvent) {

        Msg msg = msgEvent.getMsg();

        System.out.println("发送微信消息，配置信息为: " + msg.toString());

        onExecute(msg);

    }

    @Override
    public void onExecute(Msg msg) {

        System.out.println("正在发送中......");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onError(msg);

    }

    @Override
    public void onSuccess(Msg msg) {
        System.out.println("发送成功！");
    }

    @Override
    public void onError(Msg msg) {
        System.out.println("发送失败！");
    }

}
