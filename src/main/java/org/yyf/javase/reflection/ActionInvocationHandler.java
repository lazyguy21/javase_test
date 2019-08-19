package org.yyf.javase.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by @author yyf on 2019-06-23.
 */
public class ActionInvocationHandler implements InvocationHandler {
    private Object target;

    public ActionInvocationHandler(Object target) {
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("proxy class name: "+proxy.getClass().getName());
        System.out.println("method name: "+method.getName());
        System.out.println("args: "+Arrays.toString(args));
        System.out.println("do sth before original logic");
        Object result = method.invoke(target, args);
        System.out.println("do sth after original logic");
        return "wrapper: " + result;

    }
        }
