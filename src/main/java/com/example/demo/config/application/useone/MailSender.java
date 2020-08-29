package com.example.demo.config.application.useone;

import com.example.demo.config.application.listener.MyApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("mailSender")
public class MailSender {

    /**
     * 容器事件由容器触发
     */

    @Autowired
    private ApplicationContext applicationContext;

    public void sendMail(String to){
        System.out.println("MailSender开始发送邮件");
        MyApplicationEvent event = new MyApplicationEvent(applicationContext.getId());
        applicationContext.publishEvent(event);
    }

}
