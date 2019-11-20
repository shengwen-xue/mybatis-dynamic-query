package com.github.wz2cool.dynamic.mybatis;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Frank
 */
public class MathUtils {

    private MathUtils() {
        // hide
    }

    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = BigDecimal.valueOf(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }

    public static Byte getByte(Object value) {
        Byte ret = null;
        if (value != null) {
            if (value instanceof Byte) {
                ret = (Byte) value;
            } else if (value instanceof String) {
                ret = new Byte((String) value);
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a Byte.");
            }
        }
        return ret;
    }
}
