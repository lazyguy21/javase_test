package org.yyf.javase.reflection.classMeta;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.Test;

/**
 * Created by @author yyf on 2019-07-04.
 */
public class DeclaredDemo {
//    public static void main(String[] args) {
//        Method[] declaredMethodsA = A.class.getDeclaredMethods();
//        Method[] declaredMethodsB = B.class.getDeclaredMethods();
//        System.out.println(Arrays.toString(declaredMethodsA));
//        System.out.println(Arrays.toString(declaredMethodsB));
//
//
//    }

    @Test
    public void t() {
        Method[] declaredMethods = B.class.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));
        Class<? super B> superclass = B.class.getSuperclass();
        Method[] declaredMethods1 = superclass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods1));


    }

    @Test
    public void name() {
        System.out.println(B.class.getName());
        System.out.println(B.class.getSimpleName());
        System.out.println(B.class.getCanonicalName());
        System.out.println(B.class.getTypeName());

    }
}
