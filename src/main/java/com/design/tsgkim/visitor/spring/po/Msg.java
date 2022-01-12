package com.design.tsgkim.visitor.spring.po;

import lombok.Data;

import java.util.concurrent.CountDownLatch;

@Data
public class Msg {
    private String userId;
    private String userName;
    private CountDownLatch countDownLatch;
}
