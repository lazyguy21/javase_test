package org.yyf.javase.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by @author yyf on 2019-06-23.
 */
public class PerformanceTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ActionImpl action = new ActionImpl();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            action.doSth("hahaaaa");
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

        Method doth = action.getClass().getDeclaredMethod("doSth", String.class);
        doth.setAccessible(true);
        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            doth.invoke(action, "hahaaaa");
        }
        long l3 = System.currentTimeMillis();
        System.out.println(l3-l2);
    }
}
