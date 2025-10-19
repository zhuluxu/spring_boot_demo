package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: demo
 * @package: com.example.demo.config
 * @className: AppProperties
 * @author: zhuluxu
 * @description: 待添加
 * @date: 2025/10/19 18:56
 * @version: 0.0.1
 */
@ConfigurationProperties(prefix = "app")
@Component
@Data
public class AppProperties {

    // Map<String, String> 结构
    private Map<String, String> settings = new HashMap<>();

    // Map<String, Map<String, String>> 结构
    private Map<String, Map<String, String>> nestedSettings = new HashMap<>();

    // Map<String, List<String>> 结构
    private Map<String, List<String>> groupSettings = new HashMap<>();

    // Map<String, List<NestedObject>> 结构
    private Map<String, List<FeatureConfig>> features = new HashMap<>();

    @Data
    public static class FeatureConfig {
        private String name;
        private Boolean enabled;
        private List<String> permissions;
        private Map<String, String> properties;
    }
}
