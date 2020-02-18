package com.design.tsgkim.visitor.spring.controller;

import com.design.tsgkim.visitor.spring.event.MsgEvent;
import com.design.tsgkim.visitor.spring.po.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/publishMsg")
    public String publishMsg() {

        Msg msg = new Msg();
        msg.setUserId("1");
        msg.setUserName("张三");

        MsgEvent msgEvent = new MsgEvent(msg);
        applicationContext.publishEvent(msgEvent);

        return "执行完毕";

    }



}
