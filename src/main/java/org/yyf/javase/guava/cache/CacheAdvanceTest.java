package org.yyf.javase.guava.cache;

import org.junit.Test;

import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import com.google.common.cache.RemovalNotification;

import java.util.concurrent.TimeUnit;

public class CacheAdvanceTest {
  @Test
  public void test(){
    Cache cache = CacheBuilder.newBuilder()
//                              .softValues()//所有被缓存的条目都使用软引用包裹，软引用会在内存不足时被回收
                              .weakValues()//所有被缓存的条目都使用弱引用包裹，下一次gc时就会被回收
                              .concurrencyLevel(4)//如果不设置，默认4
                              .expireAfterAccess(1L, TimeUnit.MINUTES)//1分钟后失效
                              .expireAfterWrite(1L, TimeUnit.MINUTES)
                              .maximumSize(100)//缓存的最大数量
                              .ticker(new MockTicker())//ticker是个计时器，缓存是按从中读出的时间去删除超时的缓存项的。
                              .removalListener(new MyRemovalListener())//当缓存的条目被移除时的监听器，不管是手动移除，自动失效都会触发。
                              .build();

    Object nonExist = cache.getIfPresent("nonExist");
    System.out.println(nonExist);
  }

  static class MyRemovalListener implements RemovalListener {
    @Override
    public void onRemoval(final RemovalNotification notification) {

    }
  }

  static class MockTicker extends Ticker{
    private long start = Ticker.systemTicker().read();
    private long elapsedNanosecond = 0;

    @Override
    public long read() {
      return start + elapsedNanosecond;
    }

    public void addElapsedTime(long elapsedNanosecond) {
      this.elapsedNanosecond = elapsedNanosecond;
    }
  }
}
