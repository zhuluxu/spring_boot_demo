package com.example.demo.model.enmu;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @author didi
 */
public class TestEnum {

    public static void main(String[] args) {
        ManageOrderClauseEnum manageOrderClauseEnum = ManageOrderClauseEnum.assetImpactFactor;

        /**
         * 枚举类 不能直接和字符串equals比较，底层是==实现
         * manageOrderClauseEnum.name() 返回的是String字符串枚举变量名
         */
        //assetImpactFactor
        System.out.println(manageOrderClauseEnum.name());
        //true
        System.out.println(manageOrderClauseEnum.name().equals("assetImpactFactor"));
        //false
        System.out.println(manageOrderClauseEnum.equals("assetImpactFactor"));
        //assetImpactFactor
        System.out.println(ManageOrderClauseEnum.valueOf("assetImpactFactor"));
        //assetScore
        System.out.println(ManageOrderClauseEnum.values()[0]);
        //-4
        System.out.println(manageOrderClauseEnum.compareTo(ManageOrderClauseEnum.securityImpactFactor));
        //true
        System.out.println(manageOrderClauseEnum.equals(ManageOrderClauseEnum.assetImpactFactor));
        //false
        System.out.println(manageOrderClauseEnum.equals("assetImpactFactor"));
        //false
        System.out.println(manageOrderClauseEnum.equals("securityImpactFact"));

        /**
         * GameEnum
         */
        //BIG
        System.out.println(GameEnum.values()[0]);
        //BIG
        System.out.println(GameEnum.valueOf("BIG"));
        //cuowu
//        System.out.println(GameEnum.valueOf("BI"));

        Map<String, String> columnFunctionMap = ImmutableMap.<String,String>builder().put("es_doc_id", "auth_id").build();

        System.out.println(columnFunctionMap.toString());
    }
}
