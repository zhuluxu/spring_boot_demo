package com.example.demo.config.failure.analyzer;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 测试参数异常
 * @author didi
 */
@Configuration
@Log4j2
public class TestInitialConfig {
    @Value("${application.name}")
    private String applicationName;

    public TestInitialConfig() {
        String param = "TestInitialConfig";
        log.info("Param: " + param.toString());
    }
}
