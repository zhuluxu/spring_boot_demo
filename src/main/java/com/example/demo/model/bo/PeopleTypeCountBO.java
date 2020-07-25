package com.example.demo.model.bo;

import lombok.Data;

/**
 * HDFS治理数量
 *
 * @author jiangjinsheng
 * @date 2019/3/22
 */
@Data
public class PeopleTypeCountBO {
    private Integer childrenCount;

    private Integer youngPeopleCount;

    private Integer oldPeopleCount;

    private Integer allCount;

    public Integer getAllCount() {
        return allCount + 1;
    }
}
