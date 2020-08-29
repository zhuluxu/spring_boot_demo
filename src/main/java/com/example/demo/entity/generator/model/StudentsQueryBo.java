package com.example.demo.entity.generator.model;

import lombok.Data;

/**
 * @author didi
 */
@Data
public class StudentsQueryBo {

    protected boolean distinct;

    private Integer excellent;

    private Integer offset;

    private Integer limit;

    private String orderByClause;

    private String orderDirection;





}
