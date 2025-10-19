package com.example.demo.config.groovy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName:    demo 
 * @package:        com.example.demo.config.groovy
 * @className:      BenchmarkQuestionStageColumn
 * @author:     zhuluxu
 * @description:  待添加  
 * @date:    2025/10/19 17:39
 * @version:    0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenchmarkQuestionStageColumn {
    private String column;
    private String dataType;
    private String displayName;
    private Integer isDisplay;
}
