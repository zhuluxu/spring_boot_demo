package com.example.demo.model.vo;

import lombok.Data;

/**
 * @author zhuluxu
 */
@Data
public class UserInfoVO {

    private String account;

    private String name;

    private String dept;

    public String toNameDept() {
        return name + "(" + dept + ")";
    }

}
