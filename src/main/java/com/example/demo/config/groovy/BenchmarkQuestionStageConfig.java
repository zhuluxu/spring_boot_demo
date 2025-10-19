//package com.example.demo.config.groovy;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.event.EventListener;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//
///**
// * @projectName: demo
// * @package: com.example.demo.config.groovy
// * @className: BenchmarkQuestionStageConfig
// * @author: zhuluxu
// * @description: 待添加
// * @date: 2025/10/19 17:49
// * @version: 0.0.1
// */
//@Configuration
//@Slf4j
//public class BenchmarkQuestionStageConfig {
//
//    @Resource
//    private GroovyColumnConfigLoader groovyConfigLoader;
//
//    @Bean
//    @Primary
//    public Map<String, List<BenchmarkQuestionStageColumn>> columnsMap() {
//        return groovyConfigLoader.getAllConfigs();
//    }
//
//    public List<BenchmarkQuestionStageColumn> getColumnsByScenario(String scenario) {
//        return groovyConfigLoader.getColumns(scenario);
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void printConfigInfo() {
//        log.info("列配置初始化完成，业务场景数量: {}",
//                groovyConfigLoader.getAllConfigs().size());
//    }
//}