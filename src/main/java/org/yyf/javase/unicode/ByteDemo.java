package org.yyf.javase.unicode;

/**
 * Created by @author yyf on 2019-04-26.
 */
public class ByteDemo {
    public static void main(String[] args) {
        byte a = -127;
        byte b=1;
        System.out.println(a);
        System.out.println(b);
        char[] x = new char[2];
        x[0] = '\u0931';
        x[1] = '\u0003';
        System.out.println(x);
        byte[] bytes = new byte[1];
        System.out.println(bytes[0]);
    }
}
