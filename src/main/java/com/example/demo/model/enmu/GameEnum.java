package com.example.demo.model.enmu;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author didi
 */

public enum GameEnum {

    BIG(10),
    SMALL(30),
    FATTER(50);

    private Integer count;


    GameEnum(int i) {
        this.count=i;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static Boolean isValidCode(String clause) {
        //和所有values比较，看是哪个含有的枚举实例类
        return Arrays.stream(GameEnum.values()).anyMatch((type) -> type.name().equals(clause));
    }

    public static Integer getCountByClause(String clause) {
        //找到比对上的枚举实例类，取出变量值
       return  Arrays.stream(GameEnum.values()).filter((type) -> type.name().equals(clause)).map(GameEnum::getCount).findAny().orElse(0);
    }

}
