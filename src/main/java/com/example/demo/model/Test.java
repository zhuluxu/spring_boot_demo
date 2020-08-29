package com.example.demo.model;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author didi
 */
public class Test {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //"db_name" -->  dbName 字段名--->对象变量名
        String fieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "db_name");
        //"db_name" -->  setDbName 字段名--->对象方法名
        String funcName = "set" + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "db_name");
        System.out.println(funcName);

        Class clazz = PageQueryRequest.class;

        Object o = clazz.newInstance();
        Object cast = null;
        Field field = clazz.getDeclaredField("pageSize");
        Class<?> type = field.getType();


        //返回一个 方法对象，它反映此表示的类或接口的指定公共成员方法 类对象。
        Method method = clazz.getMethod(funcName, type);
//        method.invoke(o, cast);

        System.out.println("---");
    }

    public static Object transfer(LinkedHashMap<String, Object> ESDataMap, Class clazz, Map<String, String> columnFunctionMap) {
        try {
            Object o = clazz.newInstance();
            ESDataMap.forEach((k, v) -> {
                String col = k;
                //处理域对象的特殊映射关系  es_doc_id --> auth_id
                if (null != columnFunctionMap && columnFunctionMap.get(col) != null) {
                    col = columnFunctionMap.get(col);
                }
                //"db_name" -->  dbName 字段名--->对象变量名
                String fieldName = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, col);
                //"db_name" -->  setDbName 字段名--->对象方法名
                String funcName = "set" + CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, col);
                try {
                    //一个字段对象
                    Field field = clazz.getDeclaredField(fieldName);
                    //字段的声明类型
                    Class<?> type = field.getType();
                    Object cast = null;
                    if (type == Integer.class) {
                        if (v instanceof Boolean) {
                            cast = (Boolean) v ? 1 : 0;
                        } else {
                            cast = Integer.valueOf(String.valueOf(v));
                        }
                    }
                    if (type == Boolean.class) {
                        cast = Boolean.valueOf(String.valueOf(v));
                    }
                    if (type == String.class) {
                        cast = Optional.ofNullable(v).map(String::valueOf).orElse(StringUtils.EMPTY);
                    }
                    if (type == Long.class) {
                        cast = Long.parseLong(String.valueOf(v));
                    }
                    if (type == Map.class) {
//                        cast = (Map) JSON.parse(String.valueOf(v));
                    }
                    //拿到方法
                    Method method = clazz.getMethod(funcName, type);
                    //方法应用到类上，数据载入
                    method.invoke(o, cast);
                } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | NumberFormatException e) {
//                    log.debug("invoke fieldName:{}, error:{}", fieldName, e.getMessage());
                }
            });
            return o;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

    }



}
