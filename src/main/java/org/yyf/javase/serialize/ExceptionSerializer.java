package org.yyf.javase.serialize;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by tobi on 16-8-1.
 */
public class ExceptionSerializer {
    public static void main(String[] args) throws IOException {
        exceptionTest();
    }

    public static void exceptionTest() throws IOException {
        try {
            int i = 3 / 0;
        } catch (Exception e) {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("ex.txt")));
            oo.writeObject(e);
        }
    }
}
