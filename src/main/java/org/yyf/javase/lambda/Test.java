package org.yyf.javase.lambda;

/**
 * Created by yeyf on 2015-2-11.
 */
public class Test {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("cao")).start();
    }
}
