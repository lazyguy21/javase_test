package org.yyf.javase.unicode;

import java.io.UnsupportedEncodingException;

/**
 * Created by @author yyf on 2019-04-15.
 */
public class TTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        char a = 'd';
        char ch = '韡';            // 2 bytes
        // byte b1 = ch;          // error, 2 bytes to 1 byte

        byte b1 = (byte) a;      // explicit conversion from char to byte

        System.out.println("char value: " + ch);            // prints A
        System.out.println("Converted byte value: " + b1);  // prints 65 (ASCII value A)

        String s ="?";
        byte[] bytes = s.getBytes("utf-16");
        System.out.println(bytes);

//        char e='\uD801\uDC37';
        String sd = "\uD801\uDC37";
        System.out.println(sd);

        String d = "韡";
        System.out.println(d.length());

        System.out.println("\u041e\u041a");
    }
}
