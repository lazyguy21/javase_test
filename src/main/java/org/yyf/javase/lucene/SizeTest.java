package org.yyf.javase.lucene;

import com.google.common.collect.Lists;
import java.util.List;
import org.apache.lucene.util.RamUsageEstimator;

/**
 * Created by @author yyf on 2024/8/14.
 */
public class SizeTest {
//http://www.weizhi.cc/tech/detail-210273.html
  public static void main(String[] args) {
    //计算指定对象及其引用树上的所有对象的综合大小，单位字节
    List<Long> all = Lists.newArrayList();
    for (Long i = 0L; i < 300000; i++) {
     all.add(i);
    }
    long l = RamUsageEstimator.sizeOf(1L);
    String s = RamUsageEstimator.humanSizeOf(all);
    long l1 = RamUsageEstimator.shallowSizeOf(1l);
    System.out.println(l);
    System.out.println(s);
    System.out.println(l1);
////计算指定对象本身在堆空间的大小，单位字节
//    long RamUsageEstimator.shallowSizeOf(Object obj);
//
////计算指定对象及其引用树上的所有对象的综合大小，返回可读的结果，如：2KB
//    String RamUsageEstimator.humanSizeOf(Object obj);
  }

}
