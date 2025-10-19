package com.example.demo.config;

import com.example.demo.config.groovy.BenchmarkQuestionStageColumn;
import com.example.demo.config.groovy.ColumnConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @projectName: demo
 * @package: com.example.demo.config
 * @className: ValidatedPropertiesConfigLoader
 * @author: zhuluxu
 * @description: 待添加
 * @date: 2025/10/19 18:15
 * @version: 0.0.1
 */
@Component
@Slf4j
public class ValidatedPropertiesConfigLoader {

    private ColumnConfig columnConfig;

//    @PostConstruct
    public void loadConfig() {
        try {
            log.info("开始加载验证版 Properties 配置...");

            Properties props = new Properties();
            try (InputStream inputStream = getClass().getClassLoader()
                    .getResourceAsStream("column-config.properties")) {
                if (inputStream == null) {
                    throw new RuntimeException("无法找到配置文件 column-config.properties");
                }
                props.load(inputStream);
            }

            this.columnConfig = parseAndValidateProperties(props);

            log.info("验证版 Properties 配置加载完成，共 {} 个业务场景",
                    this.columnConfig.getColumnsMap().size());

        } catch (Exception e) {
            log.error("加载 Properties 配置失败", e);
            throw new RuntimeException("配置加载失败", e);
        }
    }

    private ColumnConfig parseAndValidateProperties(Properties props) {
        ColumnConfig config = new ColumnConfig();

        // 获取所有场景名称
        Set<String> scenarios = new HashSet<>();
        for (Object key : props.keySet()) {
            String keyStr = (String) key;
            if (keyStr.contains(".column.count")) {
                String scenario = keyStr.replace(".column.count", "");
                scenarios.add(scenario);
            }
        }

        // 为每个场景构建列配置
        for (String scenario : scenarios) {
            String countStr = props.getProperty(scenario + ".column.count");
            if (countStr == null) {
                log.warn("场景 {} 没有配置列数量，跳过", scenario);
                continue;
            }

            int columnCount = Integer.parseInt(countStr);
            List<BenchmarkQuestionStageColumn> columns = new ArrayList<>();

            for (int i = 0; i < columnCount; i++) {
                String baseKey = scenario + ".column." + i;

                String column = props.getProperty(baseKey + ".column");
                String dataType = props.getProperty(baseKey + ".dataType");
                String displayName = props.getProperty(baseKey + ".displayName");
                String isDisplayStr = props.getProperty(baseKey + ".isDisplay");

                // 验证必需字段
                if (column == null || dataType == null || displayName == null || isDisplayStr == null) {
                    log.warn("场景 {} 的第 {} 列配置不完整，跳过", scenario, i);
                    continue;
                }

                try {
                    Integer isDisplay = Integer.parseInt(isDisplayStr);
                    BenchmarkQuestionStageColumn col = new BenchmarkQuestionStageColumn(
                            column, dataType, displayName, isDisplay
                    );
                    columns.add(col);
                } catch (NumberFormatException e) {
                    log.warn("场景 {} 的第 {} 列的 isDisplay 值无效: {}", scenario, i, isDisplayStr);
                }
            }

            if (!columns.isEmpty()) {
                config.addScenario(scenario, columns);
            }
        }

        return config;
    }

    public List<BenchmarkQuestionStageColumn> getColumns(String scenario) {
        return columnConfig.getColumnsMap().get(scenario);
    }

    public Map<String, List<BenchmarkQuestionStageColumn>> getAllConfigs() {
        return columnConfig.getColumnsMap();
    }
}
