package org.yyf.javase.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yeyf on 2015-2-11.
 */
public class Test {
    public static void main(String[] args) {
//        new Thread(() -> System.out.println("cao")).start();
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
//        integers.stream().colcollect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
