package org.yyf.javase.baseType;

import java.util.Arrays;

/**
 * Created by tobi on 16-8-17.
 */
public class ByteTest {
    public static void main(String[] args) {
        String a = "地";
        String b = "d";
        String c = "dd1";
        byte[] bytes = a.getBytes();
        byte[] bytesb = b.getBytes();
        byte[] bytesc = c.getBytes();

        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytesb));
        System.out.println(Arrays.toString(bytesc));
    }
}
