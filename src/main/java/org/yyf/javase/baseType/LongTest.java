package org.yyf.javase.baseType;

import org.junit.Test;

import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Created by tobi on 16-9-12.
 */
public class LongTest {
//    public static void main(String[] args) {
//        Long t = 1023123122L;
//        Long t2 = 1023123122L;
//        System.out.println(t == 1023123122L);
//        System.out.println(t == t2);
//        HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
//        objectObjectHashMap.put(null, null);
//        objectObjectHashMap.put(null, null);
//        System.out.println(objectObjectHashMap);
//    }

    public static void main(String[] args) {
        Long t = 1111111L;
        Long t2= 2222223L;
        double l = (double)( t / t2);
        System.out.println(l);
    }

}
