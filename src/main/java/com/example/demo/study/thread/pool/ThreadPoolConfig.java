package com.example.demo.study.thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author didi
 */
@Configuration
public class ThreadPoolConfig {

    @Bean(name = "commonThreadPool")
    public ExecutorService newCommonThreadPool() {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("common-pool-%d").build();
        return new ThreadPoolExecutor(1, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }


}
