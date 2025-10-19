package com.example.demo.config.groovy;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: demo
 * @package: com.example.demo.config.groovy
 * @className: ColumnConfig
 * @author: zhuluxu
 * @description: 待添加
 * @date: 2025/10/19 17:40
 * @version: 0.0.1
 */
@Data
public class ColumnConfig {
    private Map<String, List<BenchmarkQuestionStageColumn>> columnsMap = new HashMap<>();

    public void addScenario(String scenario, List<BenchmarkQuestionStageColumn> columns) {
        columnsMap.put(scenario, columns);
    }

    public List<BenchmarkQuestionStageColumn> getColumns(String scenario) {
        return columnsMap.get(scenario);
    }
}