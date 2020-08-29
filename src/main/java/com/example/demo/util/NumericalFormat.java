package com.example.demo.util;


import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.NumberUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhuluxu
 */

public  class NumericalFormat {

    public NumericalFormat() {
    }
    /**
     * 格式化前端数字，-1，或null 时返回null
     *
     * @param
     * @param
     * @return
     */
    public static <T extends Number> T   parseNegativeToNull(String text,Class<T> targetClass) {
        //来源类型
        if(!ObjectUtils.isEmpty(text)){
            String trimmed = StringUtils.trimAllWhitespace(text);
            if (Byte.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Byte.decode(trimmed) : Byte.valueOf(trimmed));
            }

            if (Short.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Short.decode(trimmed) : Short.valueOf(trimmed));
            }
            if (BigInteger.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? decodeBigInteger(trimmed) : new BigInteger(trimmed));
            }
            if(Double.class == targetClass){
                return Double.valueOf(trimmed) < 0 ? null : (T) Double.valueOf(trimmed);
            }
            if(Integer.class == targetClass){
                return Integer.valueOf(trimmed) < 0 ? null : (T) Integer.valueOf(trimmed);
            }
            if(Long.class == targetClass){
                return Long.valueOf(trimmed) < 0 ? null : (T) Long.valueOf(trimmed);
            }
            if (Float.class == targetClass) {
                return Float.valueOf(trimmed) < 0 ? null : (T) Float.valueOf(trimmed);
            }
            if (BigDecimal.class != targetClass && Number.class != targetClass) {
                throw new IllegalArgumentException("Cannot convert String [" + text + "] to target class [" + targetClass.getName() + "]");
            }
            return (T) new BigDecimal(trimmed);

        }
        return null;
    }
    /**
     * 格式化前端数字，null 时返回0
     *
     * @param
     * @param
     * @return
     */
    public static <T extends Number> T parseNullToZero(String text,Class<T> targetClass) {
        //来源类型，Double,Int
        if(!ObjectUtils.isEmpty(text)){
            String trimmed = StringUtils.trimAllWhitespace(text);
            if (Byte.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Byte.decode(trimmed) : Byte.valueOf(trimmed));
            } else if (Short.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Short.decode(trimmed) : Short.valueOf(trimmed));
            } else if (Integer.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Integer.decode(trimmed) : Integer.valueOf(trimmed));
            } else if (Long.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Long.decode(trimmed) : Long.valueOf(trimmed));
            } else if (BigInteger.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? decodeBigInteger(trimmed) : new BigInteger(trimmed));
            } else if (Float.class == targetClass) {
                return (T) Float.valueOf(trimmed);
            } else if (Double.class == targetClass) {
                return (T) Double.valueOf(trimmed);
            } else if (BigDecimal.class != targetClass && Number.class != targetClass) {
                throw new IllegalArgumentException("Cannot convert String [" + text + "] to target class [" + targetClass.getName() + "]");
            } else {
                return (T) new BigDecimal(trimmed);
            }
        }
        return (T) new BigDecimal(0);
    }

    /**
     * 格式化前端数字，null 时返回-1
     *
     * @param
     * @param
     * @return
     */
    public static <T extends Number> T  parseNullToNegative(String text,Class<T> targetClass) {
        //来源类型，Double,Int
//        number instanceof Integer ? ((Integer) number) : null;
//         || Integer.valueOf(number.toString()) < 0
        if(!ObjectUtils.isEmpty(text)){
            String trimmed = StringUtils.trimAllWhitespace(text);
            if (Byte.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Byte.decode(trimmed) : Byte.valueOf(trimmed));
            } else if (Short.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Short.decode(trimmed) : Short.valueOf(trimmed));
            } else if (Integer.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Integer.decode(trimmed) : Integer.valueOf(trimmed));
            } else if (Long.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? Long.decode(trimmed) : Long.valueOf(trimmed));
            } else if (BigInteger.class == targetClass) {
                return (T) (isHexNumber(trimmed) ? decodeBigInteger(trimmed) : new BigInteger(trimmed));
            } else if (Float.class == targetClass) {
                return (T) Float.valueOf(trimmed);
            } else if (Double.class == targetClass) {
                return (T) Double.valueOf(trimmed);
            } else if (BigDecimal.class != targetClass && Number.class != targetClass) {
                throw new IllegalArgumentException("Cannot convert String [" + text + "] to target class [" + targetClass.getName() + "]");
            } else {
                return (T) new BigDecimal(trimmed);
            }
        }
        return (T) new BigDecimal(-1);
    }



    private static boolean isHexNumber(String value) {
        int index = value.startsWith("-") ? 1 : 0;
        return value.startsWith("0x", index) || value.startsWith("0X", index) || value.startsWith("#", index);
    }

    private static BigInteger decodeBigInteger(String value) {
        int radix = 10;
        int index = 0;
        boolean negative = false;
        if (value.startsWith("-")) {
            negative = true;
            ++index;
        }

        if (!value.startsWith("0x", index) && !value.startsWith("0X", index)) {
            if (value.startsWith("#", index)) {
                ++index;
                radix = 16;
            } else if (value.startsWith("0", index) && value.length() > 1 + index) {
                ++index;
                radix = 8;
            }
        } else {
            index += 2;
            radix = 16;
        }

        BigInteger result = new BigInteger(value.substring(index), radix);
        return negative ? result.negate() : result;
    }


}
