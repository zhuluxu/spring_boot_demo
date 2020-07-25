package com.example.demo;

import com.example.demo.model.bo.PeopleTypeCountBO;
import com.example.demo.model.bo.PeopleTypeQueryBO;
import com.example.demo.study.enums.ApplyTypeTestEnum;
import com.example.demo.util.NumericalFormat;
import com.google.common.collect.ImmutableMap;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

@SpringBootTest
class DemoApplicationTests {




    @Test
    void testFunction() {

        Function<Long,Integer> function = u -> Integer.valueOf(u.toString());
        Long zz = 2L;
        Integer cc = function.apply(zz);
        System.out.println(cc);

    }

    @Test
    void testFunction01() {

        Function<Long,Integer> function = new Function<Long, Integer>() {
            @Override
            public Integer apply(Long aLong) {
                return Integer.valueOf(aLong.toString());
            }
        };

        Long zz = 2L;
        Integer cc = function.apply(zz);
        System.out.println(cc);

    }

    @Test
    void testComposeAndThenFunction() {


        Function<String,Long> beforeFunction = text -> Long.valueOf(text);

        Function<Long,Integer> function = aLong -> Integer.valueOf(aLong.toString());

        Function<Integer,Double> afterFunction = text -> Double.valueOf(text);

        String  textBefore = "100";

        Long longAfter = 100L;

        //function组合beforeFunction函数，并返回新函数，注意参数类型书写正确
        Function<String,Integer> composeFunction = function.compose(beforeFunction);

        //function组合afterFunction函数，并返回新函数，注意参数类型书写正确
        Function<Long,Double> andThenFunction = function.andThen(afterFunction);

        Integer applyBefore = composeFunction.apply(textBefore);

        Double applyAfter = andThenFunction.apply(longAfter);

        Function<String,String> identityFunction = Function.identity();

        identityFunction.apply("这是一个不变的结果");

        System.out.println(identityFunction.apply("这是一个不变的结果"));

    }


    @Test
    void testGetCountEnum() {
        Map<ApplyTypeTestEnum, Function<PeopleTypeCountBO, Integer>> getMethodMap
                = ImmutableMap.<ApplyTypeTestEnum, Function<PeopleTypeCountBO, Integer>>builder()
                .put(ApplyTypeTestEnum.ALL, PeopleTypeCountBO::getAllCount)
                .put(ApplyTypeTestEnum.CHILDREN, PeopleTypeCountBO::getChildrenCount)
                .put(ApplyTypeTestEnum.OLD_PEOPLE, PeopleTypeCountBO::getOldPeopleCount)
                .put(ApplyTypeTestEnum.YOUNG_PEOPLE, PeopleTypeCountBO::getYoungPeopleCount)
                .build();

        PeopleTypeCountBO peopleTypeCountBO = new PeopleTypeCountBO();
        peopleTypeCountBO.setAllCount(100);
        peopleTypeCountBO.setChildrenCount(20);
        peopleTypeCountBO.setOldPeopleCount(10);
        peopleTypeCountBO.setYoungPeopleCount(70);

        Integer ss = getMethodMap.get(ApplyTypeTestEnum.ALL).apply(peopleTypeCountBO);

        Function<PeopleTypeCountBO, Integer> function = PeopleTypeCountBO::getAllCount;
        Function<PeopleTypeCountBO, Integer> functionGetAllCount = peopleTypeCountBO1 -> peopleTypeCountBO1.getAllCount();
        //以下二者结果相同
        function.apply(peopleTypeCountBO);
        functionGetAllCount.apply(peopleTypeCountBO);
        System.out.println(function.apply(peopleTypeCountBO));




    }


    @Test
    void contextLoads() {
        String dd = "-1";


        System.out.println(NumericalFormat.parseNegativeToNull(dd,Double.class));
//        Long storageDisqualifiedNum = 10L;
//        Long securityDisqualifiedNum = 11L;
//        Long assetDisqualifiedNum = 12L;
//        Long deptLdapNum = 50L;
//        DecimalFormat df=new DecimalFormat("0.00");
//        System.out.println(df.format(()storageDisqualifiedNum / deptLdapNum));
//        System.out.println(100 * storageDisqualifiedNum / deptLdapNum);
//        String number="10";
//        Object o = Double.valueOf(number.toString()) < 0 ? null : number;
//        System.out.println(o);
//        String dd = null;
//        Object healthScoreS = null;
////        System.out.println((int)Math.ceil(dd));
//        if (StringUtils.isEmpty((String)(healthScoreS))){
//            System.out.println("=====");
//        }
//        System.out.println(healthScoreS + "--");
//        Double ddd = NumericalFormat.parseNegativeToNull((String) healthScoreS,Double.class);
//        System.out.println(ddd);

    }

}
