//package com.example.demo.config.groovy;
//
//import groovy.lang.GroovyShell;
//import groovy.lang.Script;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StreamUtils;
//
//import javax.annotation.PostConstruct;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import java.util.Map;
//
///**
// * @projectName: demo
// * @package: com.example.demo.config.groovy
// * @className: GroovyColumnConfigLoader
// * @author: zhuluxu
// * @description: 待添加
// * @date: 2025/10/19 17:43
// * @version: 0.0.1
// */
//@Component
//@Slf4j
//public class GroovyColumnConfigLoader {
//
//    private ColumnConfig columnConfig;
//
//    @PostConstruct
//    public void loadConfig() {
//        try {
//            log.info("开始加载 Groovy 配置...");
//
//            // 创建 Groovy Shell
//            GroovyShell shell = new GroovyShell();
//
//            // 读取配置文件
//            Resource resource = new ClassPathResource("columns-config.groovy");
//            String scriptContent = StreamUtils.copyToString(
//                    resource.getInputStream(),
//                    StandardCharsets.UTF_8
//            );
//
//            // 创建 DSL 实例并绑定到脚本
//            ColumnDsl dsl = new ColumnDsl();
//            shell.setVariable("scenario", dsl.scenario);
//
//            // 执行脚本
//            shell.evaluate(scriptContent);
//
//            // 获取配置结果
//            this.columnConfig = dsl.getConfig();
//
//            log.info("Groovy 配置加载完成，共 {} 个业务场景",
//                    this.columnConfig.getColumnsMap().size());
//
//        } catch (Exception e) {
//            log.error("加载 Groovy 配置失败", e);
//            throw new RuntimeException("配置加载失败", e);
//        }
//    }
//
//    public List<BenchmarkQuestionStageColumn> getColumns(String scenario) {
//        return columnConfig.getColumnsMap().get(scenario);
//    }
//
//    public Map<String, List<BenchmarkQuestionStageColumn>> getAllConfigs() {
//        return columnConfig.getColumnsMap();
//    }
//}