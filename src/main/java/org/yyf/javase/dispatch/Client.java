package org.yyf.javase.dispatch;

/**
 * Created by tobi on 16-9-30.
 */
public class Client {
    public static void main(String[] args) {
        Bike bike = new Bike();
        Bike bikeM = new MotoBike();
//        bike.go();
//        bikeM.go();

        Person person = new Person();
        person.ride(bike);
        person.ride(bikeM);
        person.ride((MotoBike) bikeM);
    }
}
