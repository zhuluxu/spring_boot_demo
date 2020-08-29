package com.example.demo.model;

import lombok.Data;

import java.util.List;

/**
 * 分页查询结果
 *
 * @author jiangjinsheng
 * @date 2019/3/22
 */
@Data
public class PageQueryResult<T> {

    private Integer page;

    private Integer pageSize;

    private Long total;

    private List<T> records;
}
