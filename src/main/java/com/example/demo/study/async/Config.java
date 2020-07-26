package com.example.demo.study.async;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author zhuluxu
 * 异步执行配置类
 */

@EnableAsync
@Configuration
@ComponentScan("com.example.demo.study.async")
public class Config {
}
