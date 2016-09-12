package org.yyf.javase;

import java.util.BitSet;

/**
 * Created by tobi on 16-9-1.
 */
public class BitSetTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(1);
        bitSet.set(3);
        bitSet.set(0,true);
        System.out.println(bitSet.size());
    }
}
