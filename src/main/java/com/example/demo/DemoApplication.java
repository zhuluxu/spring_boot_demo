package com.example.demo;

import com.example.demo.config.application.listener.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @author didi
 */
@SpringBootApplication
@ServletComponentScan
public class DemoApplication {

    public static void main(String[] args) {
//        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
//        annotationConfigApplicationContext.publishEvent(new MyApplicationEvent("要涨工资。"));

        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.addListeners(new MyContextClosedListener());
        springApplication.addListeners(new MyContextRefreshedListener());
        springApplication.addListeners(new MyListener());
        springApplication.run(args);

    }

}
