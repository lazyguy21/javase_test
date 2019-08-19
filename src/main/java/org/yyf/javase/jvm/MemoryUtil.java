package org.yyf.javase.jvm;

import java.lang.management.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by @author yyf on 2019-06-16.
 */
public class MemoryUtil {
    public static void main(String[] args) {
        memoryPercent();
    }

    public static void memoryPercent() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

        System.out.println("heapMemoryUsage : " + toString(heapMemoryUsage));
        System.out.println("nonHeapMemoryUsage : " + toString(nonHeapMemoryUsage));
    }

    public static void t2() {
        List<MemoryManagerMXBean> memoryManagerMXBeans = ManagementFactory.getMemoryManagerMXBeans();
//        System.out.println(memoryManagerMXBeans);
        memoryManagerMXBeans.forEach(memoryManagerMXBean -> {
            String name = memoryManagerMXBean.getName();
            String[] memoryPoolNames = memoryManagerMXBean.getMemoryPoolNames();
            System.out.println("memoryManagerMXBean name: " + name);
            System.out.println("memoryManagerMXBean memoryPoolNames:" + Arrays.toString(memoryPoolNames));
        });
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        memoryPoolMXBeans.forEach(memoryPoolMXBean -> {
            String name = memoryPoolMXBean.getName();
            System.out.println("MemoryPoolMXBean name: " + name);
            MemoryUsage memoryUsage = memoryPoolMXBean.getCollectionUsage();
            System.out.println(memoryUsage);
            memoryPoolMXBean.getUsage();
        });
    }

    private static String toString(MemoryUsage memoryUsage) {
        StringBuffer buf = new StringBuffer();
        buf.append("init = " + memoryUsage.getInit() + "(" + (memoryUsage.getInit() >> 20) + "M) ");
        buf.append("used = " + memoryUsage.getUsed() + "(" + (memoryUsage.getUsed() >> 20) + "M) ");
        buf.append("committed = " + memoryUsage.getCommitted() + "(" +
                (memoryUsage.getCommitted() >> 20) + "M) ");
        buf.append("max = " + memoryUsage.getMax() + "(" + (memoryUsage.getMax() >> 20) + "M)");
        return buf.toString();
    }

}

