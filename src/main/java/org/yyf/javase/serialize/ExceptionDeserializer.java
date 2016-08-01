package org.yyf.javase.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by tobi on 16-8-1.
 */
public class ExceptionDeserializer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("ex.txt"));
        Object o = objectInputStream.readObject();
        Exception ex = (Exception) o;
        ex.printStackTrace();
    }
}
