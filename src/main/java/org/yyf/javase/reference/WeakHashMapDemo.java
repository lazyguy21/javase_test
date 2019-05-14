package org.yyf.javase.reference;

import java.util.WeakHashMap;

class WeakHashMapDemo {
    public static void main(String args[]) throws Exception {
        WeakHashMap m = new WeakHashMap();
        DemoObject d = new DemoObject();

        // puts an entry into WeakHashMap
        m.put(d, " Hi ");
        System.out.println(m);

        d = null;

        // garbage collector is called
        System.gc();

        // thread sleeps for 4 sec
        Thread.sleep(4000);

        System.out.println(m);
    }
}

