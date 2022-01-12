package com.design.tsgkim.visitor.spring.controller;

import com.design.tsgkim.visitor.spring.event.MsgApplicationListener;
import com.design.tsgkim.visitor.spring.event.MsgEvent;
import com.design.tsgkim.visitor.spring.po.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
public class MsgController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/publishMsg")
    public String publishMsg() throws InterruptedException {

        Msg msg = new Msg();
        msg.setUserId("1");
        msg.setUserName("张三");

        CountDownLatch countDownLatch = new CountDownLatch(applicationContext.getBeanNamesForType(MsgApplicationListener.class).length);
        msg.setCountDownLatch(countDownLatch);

        MsgEvent msgEvent = new MsgEvent(msg);
        applicationContext.publishEvent(msgEvent);

        countDownLatch.await();

        return "执行完毕";

    }



}
