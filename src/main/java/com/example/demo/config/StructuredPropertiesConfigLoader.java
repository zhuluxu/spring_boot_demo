//package com.example.demo.config;
//
//import com.example.demo.config.groovy.BenchmarkQuestionStageColumn;
//import com.example.demo.config.groovy.ColumnConfig;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @projectName: demo
// * @package: com.example.demo.config
// * @className: StructuredPropertiesConfigLoader
// * @author: zhuluxu
// * @description: 待添加
// * @date: 2025/10/19 18:12
// * @version: 0.0.1
// */
//@Component
//@Slf4j
//public class StructuredPropertiesConfigLoader {
//
//    @Autowired
//    private ColumnConfigProperties properties;
//
//    private ColumnConfig columnConfig;
//
//    @PostConstruct
//    public void loadConfig() {
//        log.info("开始加载结构化 Properties 配置...");
//
//        this.columnConfig = new ColumnConfig();
//
//        for (Map.Entry<String, List<ColumnConfigProperties.ColumnProperty>> entry :
//                properties.getColumnConfig().entrySet()) {
//            String scenario = entry.getKey();
//            List<ColumnConfigProperties.ColumnProperty> props = entry.getValue();
//
//            List<BenchmarkQuestionStageColumn> columns = props.stream()
//                    .map(prop -> new BenchmarkQuestionStageColumn(
//                            prop.getColumn(),
//                            prop.getDataType(),
//                            prop.getDisplayName(),
//                            prop.getIsDisplay()
//                    ))
//                    .collect(Collectors.toList());
//
//            this.columnConfig.addScenario(scenario, columns);
//        }
//
//        log.info("结构化 Properties 配置加载完成，共 {} 个业务场景",
//                this.columnConfig.getColumnsMap().size());
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
