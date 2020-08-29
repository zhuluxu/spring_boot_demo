package com.example.demo.model;

import lombok.Data;

/**
 * 分页查询
 *
 * @author jiangjinsheng
 * @date 2019/3/22
 */
@Data
public class PageQueryRequest {

    private Integer page = 1;

    private Integer pageSize = 10;

    private String dbName;
}
