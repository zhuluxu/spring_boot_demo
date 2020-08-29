package com.example.demo.config.application.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/**
 * @author didi
 * ApplicationEvent 全部事件监听
 *
 *
 * MyApplicationEvent  只监听MyApplicationEvent
 *
 * 通过spring的监听器，我们不仅可以实现自己相关的业务，还可以通过这个机制将我们自己的组件和spring进行整合，比如阿里的nacos就是通过ApplicationListener与spring整合的；
 *
 * springboot和spring中的一些事件：
 *
 * ContextClosedEvent：容器关闭的时候，我们可以监听这个事件在容器关闭的时候去清理一些缓存（比如redis）的数据
 *
 *
 *
 * ApplicationFailedEvent：该事件为spring boot启动失败时的操作
 *
 * ApplicationPreparedEvent：上下文context准备时触发
 *
 * ApplicationReadyEvent：上下文已经准备完毕的时候触发，做权限认证的时候。在这个时候就可以去初始化一些权限数据。或者预备其他数据
 *
 * ApplicationEnvironmentPreparedEvent：环境事先准备
 */
@Component
@Log4j2
@Service("myListener")
public class MyListener implements ApplicationListener<ApplicationEvent> {

    /**
     * 调用ApplicationContext.publishEvent方法时会触发执行该方法
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.info("收到事件：" + event.toString());


        if(event instanceof ServletRequestHandledEvent){
            //强制转换
            ServletRequestHandledEvent evt=(ServletRequestHandledEvent) event;
            System.out.println("#####################");
            System.out.println("一次请求发生");
            System.out.println(event.toString());
            System.out.println("#####################");
        }

        //如果容器关闭时，触发
        if(event instanceof ContextClosedEvent){
            ContextClosedEvent cce=(ContextClosedEvent) event;
            System.out.println("#####################");
            System.out.println("容器关闭");
            System.out.println(cce);
            System.out.println("#####################");
        }
        //容器刷新时候触发
        if(event instanceof ContextRefreshedEvent){
            ContextRefreshedEvent cre=(ContextRefreshedEvent) event;
            System.out.println("#####################");
            System.out.println("容器刷新");
            System.out.println(cre);
            System.out.println("#####################");
        }
        //容器启动的时候触发
        if(event instanceof ContextStartedEvent){
            ContextStartedEvent cse=(ContextStartedEvent) event;
            System.out.println("#####################");
            System.out.println("容器启动");
            System.out.println(cse);
            System.out.println("#####################");
        }
        //容器停止时候触发
        if(event instanceof ContextStoppedEvent){
            ContextStoppedEvent cse=(ContextStoppedEvent) event;
            System.out.println("#####################");
            System.out.println("容器停止");
            System.out.println(cse);
            System.out.println("#####################");
        }

        //判断事件为MyEvent时候执行
        if(event instanceof MyApplicationEvent){
            //强制转换
            MyApplicationEvent evt=(MyApplicationEvent) event;
            //执行自定义事件中的自定义方法
            evt.myApplicationEvent();
        }
    }
}
