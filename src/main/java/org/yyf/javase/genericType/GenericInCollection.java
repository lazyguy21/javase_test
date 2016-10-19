package org.yyf.javase.genericType;

import org.junit.Test;
import org.yyf.javase.domain.Animal;
import org.yyf.javase.domain.Dog;

import java.util.ArrayList;

/**
 * Created by tobi on 16-10-12.
 */
public class GenericInCollection {
    public static void main(String[] args) {
        ArrayList<Animal> animalList = new ArrayList<>();

        ArrayList<Dog> dogList = new ArrayList<>();
        Dog dog = new Dog();
        Animal animal = new Animal();
        animalList.add(dog);
//        animalList = dogList;不行

        ArrayList<? super Animal> animals2 = new ArrayList<>();
        animals2.add(dog);
    }
    @Test
    public void arrayT(){
        Object[] t = new Integer[1];
        t[0] = "asdf";
        System.out.println(t[0]);
    }
    @Test
    public void extendsTest(){
        ArrayList<? extends Animal> aList=new ArrayList<Dog>();

        Dog dog = new Dog();
//        aList.add(dog);

    }
}
