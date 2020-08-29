package com.example.demo.config.application.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEvent;

/**
 * 新建一个自己的事件
 * @author didi
 */
@Log4j2
public class MyApplicationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     * @param source the object on which the event initially occurred (never {@code null})
     */


    /**
     * 存放构造器送入的值
     */
    private String msg;


    /**
     * 构造器参数可以随意设置，这里为了方便调试，设置为字符串
     * @param msg
     */
    public MyApplicationEvent(String msg) {
        super(msg);
        this.msg=msg;
    }
    /**
     * 自定义一个方法，这个方法也可以随意写，这里也是测试用
     */

    public void myApplicationEvent(){
        System.out.println("********My event**************");
        System.out.println(msg);
        log.info(msg);
        System.out.println("*******************************");
    }
}
