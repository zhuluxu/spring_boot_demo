package com.example.demo.config;

import com.example.demo.config.application.listener.MyApplicationEvent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Configuration;

/**
 * @author didi
 */
@Configuration
@MapperScan(value = {"com.example.demo.dao.generator","com.example.demo.dao"})
public class MybatisConfig {


}
