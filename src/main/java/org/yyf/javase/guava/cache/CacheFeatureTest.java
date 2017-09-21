package org.yyf.javase.guava.cache;

import org.junit.Before;
import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class CacheFeatureTest {
  LoadingCache<String, String> cache;

  @Before
  public void setUp() {
    cache = CacheBuilder.newBuilder()
                        .build(new MyCacheLoader());
  }

  /**
   * 刷新表示为键加载新值，这个过程可以是异步的。
   * 在刷新操作进行时， 缓存仍然可以向其他线程返回旧值，
   * 而不像回收操作，读缓存的线程必须等待新值加载完成
   * @throws Exception
   */
  @Test
  public void testRefresh() throws Exception {
    for (int i = 0; i < 10; i++) {
      cache.refresh(String.valueOf(i));
    }
  }

  /**
   * cacheLoader负责从底层的数据源加载 键对应的值
   */
  @Test
  public void testCacheLoader() {
    LoadingCache<String, String> cache
        = CacheBuilder.newBuilder()
                      .build(new MyCacheLoader());
    System.out.println(cache.getUnchecked("张三"));
    System.out.println(cache.getUnchecked("张三"));

    try {
      cache.get("李四", new Callable<String>() {
        @Override
        public String call() throws Exception {
          return null;
        }
      });
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }

  static class MyCacheLoader extends CacheLoader<String, String> {
    @Override
    public String load(final String key) throws Exception {
      long currentTimeMillis = System.currentTimeMillis();
      String value = key + "_" + currentTimeMillis;
      System.out.println(String.format("mock get value (%s) associated with key (%s) from some db source", value, key));
      return value;
    }

    /**
     * reload默认实现是同步调用load方法。可以重写为异步的。
     * @param key
     * @param oldValue
     * @return
     * @throws Exception
     */
    @Override
    public ListenableFuture<String> reload(final String key, final String oldValue) throws Exception {
      return super.reload(key, oldValue);
    }
  }

  static class NullCacheLoader extends CacheLoader<String, String> {
    @Override
    public String load(final String key) throws Exception {

      return null;
    }
  }
}
