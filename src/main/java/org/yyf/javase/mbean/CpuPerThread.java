package org.yyf.javase.mbean;

import java.lang.management.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CpuPerThread {
    private int sampleTime = 20000;
    private ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
    private RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
    private OperatingSystemMXBean osMxBean = ManagementFactory
            .getOperatingSystemMXBean();
    private Map<Long, Long> threadInitialCPU = new HashMap<Long, Long>();
    private Map<String, String> threadCPUUsage = new HashMap<>();
    private long initialUptime = runtimeMxBean.getUptime();

    public static void main(String[] args) {

        new Thread("Dummy thread") {
            @Override
            public void run() {
                int i = 0;
                while (i++ < 10000000) {
//                    System.out.println(i);
                }
            }
        }.start();

        new Thread("Dummy thread 2") {
            @Override
            public void run() {
                int i = 0;
                while (i++ < 10000000) {
//                    System.out.println(i);
                }
            }
        }.start();
        new CpuPerThread().measure();
    }

    private void measure() {
        ThreadInfo[] threadInfos = threadMxBean.dumpAllThreads(false, false);
        Map<Long, Long> cpuTimeOfThreadStart = getCpuTimeOfThread();
        //睡20s
        try {
            Thread.sleep(sampleTime);
        } catch (InterruptedException e) {
        }
        //得到jvm运行的时间
        long upTime = runtimeMxBean.getUptime();

        Map<Long, Long> cpuTimeOfThreadEnd = getCpuTimeOfThread();

        // CPU over all processes  得到cpu核心数
        int nrCPUs = osMxBean.getAvailableProcessors();
        // total CPU: CPU % can be more than 100% (devided over multiple cpus)
        //long nrCPUs = 1;
        // elapsedTime is in ms.

        //jvm启动到运行upTime(第一次统计线程)中间过去的时间，既当开始
        long elapsedTime = (upTime - initialUptime);
        for (ThreadInfo info : threadInfos) {
            Long delta = calculateDelta(cpuTimeOfThreadStart, cpuTimeOfThreadEnd,info.getThreadId());
            // elapsedCpu is in ns
                //此段时间内线程占用cpu的时间,ns 单位
                //时间段（纳秒）=当前耗时-第一次耗时
                //elapsedTime * 1000000f * nrCPUs 代表着cpu的所有时间
                //elapsedCpu 代表着这个线程所占有的时间
                double cpuUsage = delta / (elapsedTime * 1000000f * nrCPUs);
                threadCPUUsage.put(info.getThreadId() + "-" + info.getThreadName(), String.format("%.2f", cpuUsage));
        }

        // threadCPUUsage contains cpu % per thread
        System.out.println("threadCPUUsage:");
        System.out.println(threadCPUUsage);

        // You can use osMxBean.getThreadInfo(theadId) to get information on
        // every thread reported in threadCPUUsage and analyze the most CPU
        // intentive threads

    }

    private Map<Long, Long> getCpuTimeOfThread() {
        ThreadInfo[] threadInfos = threadMxBean.dumpAllThreads(false, false);
        Map<Long, Long> threadCpuTime = Stream.of(threadInfos)
                .collect(Collectors.toMap(
                        ThreadInfo::getThreadId,
                        threadInfo -> threadMxBean.getThreadCpuTime(threadInfo.getThreadId()
                        )));
        return threadCpuTime;

    }

    /**
     * 返回的前后差距是纳秒
     * @param cpuTimeOfThreadStart
     * @param cpuTimeOfThreadEnd
     * @param threadId
     * @return
     */
    public Long calculateDelta(Map<Long, Long> cpuTimeOfThreadStart, Map<Long, Long> cpuTimeOfThreadEnd,Long threadId) {
        Long cpuTimeStart = cpuTimeOfThreadStart.get(threadId);
        Long cpuTimeEnd = cpuTimeOfThreadEnd.get(threadId);
        long delta = cpuTimeEnd - cpuTimeStart;
        return delta;
    }
}