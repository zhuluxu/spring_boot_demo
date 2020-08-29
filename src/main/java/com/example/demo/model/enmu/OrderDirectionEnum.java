package com.example.demo.model.enmu;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * @author onealzhuyingjie
 * @date 20190423 上午10:39
 **/
@Getter
@AllArgsConstructor
public enum OrderDirectionEnum {
    DESC("desc"),ASC("asc");

    private String direction;

    public static boolean isValidCode(String direction) {
        return Arrays.stream(OrderDirectionEnum.values()).anyMatch((type) -> type.getDirection().equals(direction));
    }
}
