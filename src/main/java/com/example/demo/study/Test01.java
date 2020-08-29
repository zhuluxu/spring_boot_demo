package com.example.demo.study;

import org.springframework.util.NumberUtils;

import java.math.BigDecimal;

/**
 * @author didi
 */
public class Test01 {
    private static String[] obj = new String[4];
    public static void main(String[] args) {

//            Double doubleScore = NumberUtils.parseNumber("0",Double.class);
//        System.out.println(BigDecimal.valueOf(doubleScore).setScale(2,BigDecimal.ROUND_CEILING).doubleValue());

        String test = "C2:gulfstream_dwd.dwd_order_make_d.driver_id,C3:gulfstream_dw.dw_v_driver_base";
        String[] columns = test.split(",");
        if (columns == null || columns.length == 0){
            return;
        }
        for (String column : columns) {
            obj = new String[]{"", "", "", ""};
            String security = column.split(":",2)[0];
            String[] dbTable = column.split(":",2)[1].split("\\.",3);
            obj[0] = security;
            for (int i = 0; i < dbTable.length; i++) {
                obj[i+1] = dbTable[i];
            }
            for (String s : obj) {
                System.out.println(s);
            }
        }


    }
}
