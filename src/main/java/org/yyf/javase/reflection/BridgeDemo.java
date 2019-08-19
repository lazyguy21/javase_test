package org.yyf.javase.reflection;

import java.lang.reflect.Method;

/**
 * Created by @author yyf on 2019-06-22.
 */
public class BridgeDemo {
    public static void main(String[] args) {
        Method[] methods = ExtendDemo.class.getMethods();
        for (Method method : methods) {
            boolean bridge = method.isBridge();
            System.out.println(bridge);
        }
    }
}
