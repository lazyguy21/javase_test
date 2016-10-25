package org.yyf.javase.guava.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.HashMultiset;

import org.junit.Test;

import java.util.Set;

/**
 * Created by tobi on 16-10-19.
 */
public class CollectionTest {
    @Test
    public void testMultiSet() {
        HashMultiset<Object> hashMultiset = HashMultiset.create();
        hashMultiset.add(1);
        hashMultiset.add(1);
        hashMultiset.add("apple");
        hashMultiset.add("apple");
        hashMultiset.add("apple");
        int size = hashMultiset.size();
        System.out.println(size);
        int apple = hashMultiset.count("apple");
        int banana = hashMultiset.count("banana");
        System.out.println(apple);
        System.out.println(banana);
    }

    @Test
    public void testMultiMap() throws Exception {
        HashMultimap<String, Object> hashMultimap = HashMultimap.create(1, 1);
        hashMultimap.put("apple", "红富士");
        hashMultimap.put("apple", "普通货色");
        hashMultimap.put("apple", "烂苹果");
        Set<Object> apple = hashMultimap.get("apple");
        System.out.println(apple);
    }

    @Test
    public void testBiMap() throws Exception {
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        logfileMap.put(1, "a.log");
        logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        BiMap<String, Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:" + filelogMap);
    }
}
