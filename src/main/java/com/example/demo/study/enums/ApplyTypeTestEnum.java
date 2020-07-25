package com.example.demo.study.enums;


import com.example.demo.model.bo.PeopleTypeCountBO;
import com.example.demo.model.bo.PeopleTypeQueryBO;
import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;


/**
 *
 *
 * @author zhuluxu
 * @date 2019/3/22
 */
@Getter
@AllArgsConstructor
public enum ApplyTypeTestEnum {
    YOUNG_PEOPLE(1, "youngPeople", "年轻人"),
    OLD_PEOPLE(2, "oldPeople", "老年人"),
    CHILDREN(3, "children", "孩童"),
    ALL(4,"all","全部")
    ;

    private Integer typeCode;

    private String type;

    private String typeName;


    private static Map<ApplyTypeTestEnum, BiConsumer<PeopleTypeQueryBO, Integer>> setMethodMap
            = ImmutableMap.<ApplyTypeTestEnum, BiConsumer<PeopleTypeQueryBO, Integer>>builder()
            .put(ALL, (u,v)->{})
            .put(CHILDREN, PeopleTypeQueryBO::setChildren)
            .put(OLD_PEOPLE, PeopleTypeQueryBO::setOldPeople)
            .put(YOUNG_PEOPLE, PeopleTypeQueryBO::setYoungPeople)
            .build();

    private static Map<ApplyTypeTestEnum, Function<PeopleTypeCountBO, Integer>> getMethodMap
            = ImmutableMap.<ApplyTypeTestEnum, Function<PeopleTypeCountBO, Integer>>builder()
            .put(ALL, PeopleTypeCountBO::getAllCount)
            .put(CHILDREN, PeopleTypeCountBO::getChildrenCount)
            .put(OLD_PEOPLE, PeopleTypeCountBO::getOldPeopleCount)
            .put(YOUNG_PEOPLE, PeopleTypeCountBO::getYoungPeopleCount)
            .build();

    public static Integer getTypeCount(PeopleTypeCountBO tableManageCountBO, ApplyTypeTestEnum hdfsManageTypeEnum) {
        return getMethodMap.get(hdfsManageTypeEnum).apply(tableManageCountBO);
    }

    public static void setTypeCode(PeopleTypeQueryBO hdfsManageQueryBO, ApplyTypeTestEnum hdfsManageTypeEnum) {
        setMethodMap.get(hdfsManageTypeEnum).accept(hdfsManageQueryBO, 1);
    }

    public static boolean isValidCode(Integer codeToCheck) {
        return Arrays.stream(ApplyTypeTestEnum.values()).anyMatch((type) -> type.getTypeCode().equals(codeToCheck));
    }

    public static ApplyTypeTestEnum getTypeByCode(Integer typeCode) {
        for (ApplyTypeTestEnum value : ApplyTypeTestEnum.values()) {
            if (value.getTypeCode().equals(typeCode)) {
                return value;
            }
        }
        return null;
    }

    public static ApplyTypeTestEnum getTypeByCode(String typeCode) {
        for (ApplyTypeTestEnum value : ApplyTypeTestEnum.values()) {
            if (value.getType().equals(typeCode)) {
                return value;
            }
        }
        return null;
    }

    public static Integer validAndGet(Integer codeToCheck, ApplyTypeTestEnum typeEnum) {
        if (!ApplyTypeTestEnum.isValidCode(codeToCheck)) {
            return typeEnum.getTypeCode();
        }
        return codeToCheck;
    }

    public static String validAndGet(String codeToCheck, ApplyTypeTestEnum typeEnum) {
        if (null == getTypeByCode(codeToCheck)) {
            return typeEnum.getType();
        }
        return codeToCheck;
    }
}
