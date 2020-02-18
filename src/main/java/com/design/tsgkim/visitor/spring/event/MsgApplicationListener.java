package com.design.tsgkim.visitor.spring.event;

import com.design.tsgkim.visitor.spring.po.Msg;
import org.springframework.context.ApplicationListener;

/**
 * 发布 - 订阅者模式，也叫观察者模式
 *
 * @author: shiguang.tu
 * @create: 2020/2/18 3:12 PM
 */
public interface MsgApplicationListener extends ApplicationListener<MsgEvent> {

    void onExecute(Msg msg);

    void onSuccess(Msg msg);

    void onError(Msg msg);

}
