package org.yyf.javase.reflection;

import java.lang.reflect.Proxy;

/**
 * Created by @author yyf on 2019-06-23.
 */
public class ActionImpl implements ActionI {
    @Override
    public String doSth(String param) {
//        System.out.println("echo in dothing");
        return "echo: " + param;
    }


}


