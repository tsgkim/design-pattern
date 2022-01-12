package com.design.tsgkim.visitor.spring.event;

import com.design.tsgkim.visitor.spring.po.Msg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsListener implements MsgApplicationListener {

    @Async
    @Override
    public void onApplicationEvent(MsgEvent msgEvent) {
        Msg msg = msgEvent.getMsg();
        log.info("发送短信消息，配置信息为:{}" + msg.toString());
        onExecute(msg);
    }

    @Override
    public void onExecute(Msg msg) {
        log.info("正在发送短信消息中......");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onSuccess(msg);

        msg.getCountDownLatch().countDown();
    }

    @Override
    public void onSuccess(Msg msg) {
        log.info("发送短信消息成功！");
    }

    @Override
    public void onError(Msg msg) {
        log.info("发送短信消息失败！");
    }

}
