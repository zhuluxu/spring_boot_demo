package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @projectName: demo
 * @package: com.example.demo.config
 * @className: ColumnConfigProperties
 * @author: zhuluxu
 * @description: 待添加
 * @date: 2025/10/19 18:11
 * @version: 0.0.1
 */
@ConfigurationProperties(prefix = "column-config")
@Component
@Data
@Validated
public class ColumnConfigProperties {

    @NotEmpty(message = "至少需要配置一个业务场景")
    private Map<String, List<@Valid ColumnProperty>> scenarios = new HashMap<>();

    @Data
    @Validated
    public static class ColumnProperty {

        @NotBlank(message = "列名不能为空")
        private String column;

        @NotBlank(message = "数据类型不能为空")
        private String dataType;

        @NotBlank(message = "显示名称不能为空")
        private String displayName;

        @NotNull(message = "显示状态不能为空")
        @Min(value = 0, message = "显示状态必须为 0 或 1")
        @Max(value = 1, message = "显示状态必须为 0 或 1")
        private Integer isDisplay;
    }

    public List<ColumnProperty> getColumnsForScenario(String scenarioName) {
        return scenarios.get(scenarioName);
    }

    public Set<String> getAllScenarioNames() {
        return scenarios.keySet();
    }
}
