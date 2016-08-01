package org.yyf.javase.serialize;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by tobi on 16-7-26.
 */
public class ClientB {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));
        Object o = objectInputStream.readObject();
        System.out.println(o);
    }
}
