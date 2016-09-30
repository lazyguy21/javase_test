package org.yyf.javase.dispatch;

/**
 * Created by tobi on 16-9-30.
 */
public class Person {
    public void ride(Bike bike) {
        System.out.println("bike invoked");
        bike.go();
    }
    public void ride(MotoBike motoBike){
        System.out.println("motobike invoked!");
        motoBike.go();
    }
}
