package org.yyf.javase.dispatch;

/**
 * Created by tobi on 16-9-30.
 */
public class Bike implements Vehicle {
    @Override
    public void go() {
        System.out.println("自行车用脚踩着跑");
    }

}
