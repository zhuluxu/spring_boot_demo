package com.example.demo.controller;

import com.example.demo.config.ColumnConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @projectName: demo
 * @package: com.example.demo.controller
 * @className: ColumnConfigController
 * @author: zhuluxu
 * @description: 待添加
 * @date: 2025/10/19 18:21
 * @version: 0.0.1
 */
@RestController
@RequestMapping("/api/column-config")
public class ColumnConfigController {
    @Autowired
    private ColumnConfigProperties config;

    @GetMapping("/{scenario}")
    public ResponseEntity<List<ColumnConfigProperties.ColumnProperty>> getColumns(@PathVariable String scenario) {
        List<ColumnConfigProperties.ColumnProperty> columns = config.getScenarios().get(scenario);
        return ResponseEntity.ok(columns != null ? columns : Collections.emptyList());
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, List<ColumnConfigProperties.ColumnProperty>>> getAllConfigs() {
        return ResponseEntity.ok(config.getScenarios());
    }
}
