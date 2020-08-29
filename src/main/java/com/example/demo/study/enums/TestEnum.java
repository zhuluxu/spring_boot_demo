package com.example.demo.study.enums;

import java.util.Arrays;

/**
 * @author didi
 */
public class TestEnum {
    public static void main(String[] args) {
        for (ApplyTypeTestEnum value : ApplyTypeTestEnum.values()) {
            System.out.println(value.name());
        }
    }
}
