package org.yyf.javase;

import java.util.Objects;

/**
 * Created by tobi on 16-8-23.
 */
public class NullCompareTest {
    public static void main(String[] args) {
        Boolean a = null;
        System.out.println(a);
        /*
        if(a){//java并不会将null默认为false，这一点跟大多数语言并不一样
            System.out.println(a);
        }
        */
//        System.out.println(true==a);//同理
        System.out.println(Objects.equals(null, null));
    }
}
