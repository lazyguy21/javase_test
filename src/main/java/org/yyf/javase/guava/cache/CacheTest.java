package org.yyf.javase.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by tobi on 16-10-21.
 */
public class CacheTest {
    @Test
    public void testBuild() {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "the value of the " + key;
            }
        });
        try {
            System.out.println(cache.get("nonExistKey"));
            System.out.println(cache.get(null));
        } catch (ExecutionException e) {
            System.out.println("haha");
            e.printStackTrace();
        }
        System.out.println(cache.getUnchecked(null));
    }

    @Test
    public void testBuildNoException() {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "the value of the " + key;
            }
        });
        System.out.println(cache.getUnchecked("dfd"));
    }
}
