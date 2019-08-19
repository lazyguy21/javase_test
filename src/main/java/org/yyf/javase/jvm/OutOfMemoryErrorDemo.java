package org.yyf.javase.jvm;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by @author yyf on 2019-06-06.
 */
public class OutOfMemoryErrorDemo {

    public static void main(String[] args) {
        List list = Lists.newArrayList();
        while (true) {
//            list.add( new byte[1024*1024]);
            list.add( new byte[102]);
            try {
                TimeUnit.MILLISECONDS.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
