package org.yyf.javase.reference;

import java.util.HashMap;

class HashMapDemo {
    public static void main(String args[]) throws Exception {
        HashMap m = new HashMap();
        DemoObject d = new DemoObject();

        // puts an entry into HashMap 
        m.put(d, " Hi ");

        System.out.println(m);
        d = null;

        // garbage collector is called 
        System.gc();

        //thread sleeps for 4 sec 
        Thread.sleep(4000);

        System.out.println(m);
    }
}

