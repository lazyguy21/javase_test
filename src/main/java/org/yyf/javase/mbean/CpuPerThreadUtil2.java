//package org.yyf.javase.mbean;
//
//import lombok.extern.slf4j.Slf4j;
//
//import java.lang.management.*;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Slf4j
//public class CpuPerThreadUtil2 {
//    private static ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
//    private static RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
//    private static OperatingSystemMXBean osMxBean = ManagementFactory
//            .getOperatingSystemMXBean();
//    private static Map<Long, Long> cpuTimeOfThreadStart = new HashMap<>();
//    private static Map<Long, Long> cpuTimeOfThreadEnd = new HashMap<>();
//    private static Long cpuTimeStart;
//    private static Long cpuTimeEnd;
//    private static int nrCPUs = osMxBean.getAvailableProcessors();
//    ;
//    private int sampleTime = 20000;
//    private Map<String, String> threadCPUUsage = new HashMap<>();
//    private long initialUptime = runtimeMxBean.getUptime();
//
//
//    private static void calculate() {
//        Set<Long> threadIds = getThreadIds();
//        Map<Long, Long> deltaTimePerThreadMap = threadIds.stream().collect(Collectors.toMap(Function.identity(), CpuPerThreadUtil::calculateDelta));
//        Long jvmTime = (cpuTimeEnd - cpuTimeStart) * 1000000 * nrCPUs;
//        print(deltaTimePerThreadMap, jvmTime);
//    }
//
//    private static Long getCpuUpTime() {
//        //得到jvm运行的时间
//        return runtimeMxBean.getUptime() * 1000000;
//    }
//
//    public static void start() {
//        cpuTimeStart = getCpuUpTime();
//        cpuTimeOfThreadStart = getCpuTimeOfThread();
//    }
//
//    public static void end() {
//        cpuTimeEnd = getCpuUpTime();
//        cpuTimeOfThreadEnd = getCpuTimeOfThread();
//        calculate();
//    }
//
//    private static Set<Long> getThreadIds() {
//        Set<Long> threadIdsStart = cpuTimeOfThreadStart.keySet();
//        Set<Long> threadIdsEnd = cpuTimeOfThreadEnd.keySet();
//
//        Set<Long> result = new HashSet<>();
//
//        result.addAll(threadIdsStart);
//        result.addAll(threadIdsEnd);
//        return result;
//    }
//
//    private static Map<Long, Long> getCpuTimeOfThread() {
//        ThreadInfo[] threadInfos = threadMxBean.dumpAllThreads(false, false);
//        Map<Long, Long> threadCpuTime = Stream.of(threadInfos)
//                .collect(Collectors.toMap(
//                        ThreadInfo::getThreadId,
//                        threadInfo -> threadMxBean.getThreadCpuTime(threadInfo.getThreadId()
//                        )));
//        return threadCpuTime;
//
//    }
//
//    private static Long calculateDelta(Long threadId) {
//        Long cpuTimePerThreadStart = cpuTimeOfThreadStart.get(threadId);
//        if (cpuTimePerThreadStart == null) {
//            log.info("cpuTimePerThreadStart null,threadId:{}", threadId);
//            cpuTimePerThreadStart = 0L;
//        }
//        Long cpuTimePerThreadEnd = cpuTimeOfThreadEnd.get(threadId);
//        if (cpuTimePerThreadEnd == null) {
//            log.info("cpuTimePerThreadEnd null,threadId:{}", threadId);
//            cpuTimePerThreadEnd = cpuTimePerThreadStart;
//        }
//        Long delta = cpuTimePerThreadEnd - cpuTimePerThreadStart;
//        return delta;
//    }
//
//    private static void print(Map<Long, Long> deltaTimePerThreadMap) {
//        deltaTimePerThreadMap.entrySet().stream().sorted((o1, o2) -> {
//            return o1.getValue() > o2.getValue() ? 1 : -1;
//        }).forEachOrdered(entry -> {
//            ThreadInfo info = threadMxBean.getThreadInfo(entry.getKey());
//            if (info == null) {
//                log.error("info null,threadId:{}", entry.getKey());
//            } else {
//                log.info("threadId:{},threadName:{} , threadCpuTime:{}", info.getThreadId(), info.getThreadName(), entry.getValue());
//            }
//        });
//    }
//
//    private static void print(Map<Long, Long> deltaTimePerThreadMap, Long jvmTime) {
//        deltaTimePerThreadMap.entrySet().stream().sorted((o1, o2) -> {
//            return o1.getValue() > o2.getValue() ? 1 : -1;
//        }).forEachOrdered(entry -> {
//            ThreadInfo info = threadMxBean.getThreadInfo(entry.getKey());
//            if (info == null) {
//                log.error("info null,threadId:{}", entry.getKey());
//            } else {
//                Long value = entry.getValue();
//                double l = ((double) value / jvmTime);
//
//                log.info("threadId:{},threadName:{} , threadCpuTime:{}, rate:{}", info.getThreadId(), info.getThreadName(), entry.getValue(), l);
//            }
//        });
//    }
//
//    private void measure() {
//        ThreadInfo[] threadInfos = threadMxBean.dumpAllThreads(false, false);
//        Map<Long, Long> cpuTimeOfThreadStart = getCpuTimeOfThread();
//
//        //得到jvm运行的时间
//        long upTime = runtimeMxBean.getUptime();
//
//        Map<Long, Long> cpuTimeOfThreadEnd = getCpuTimeOfThread();
//
//        // CPU over all processes  得到cpu核心数
//        int nrCPUs = osMxBean.getAvailableProcessors();
//        // total CPU: CPU % can be more than 100% (devided over multiple cpus)
//        //long nrCPUs = 1;
//        // elapsedTime is in ms.
//
//        //jvm启动到运行upTime(第一次统计线程)中间过去的时间，既当开始
//        long elapsedTime = (upTime - initialUptime);
//        for (ThreadInfo info : threadInfos) {
//            Long delta = calculateDelta(cpuTimeOfThreadStart, cpuTimeOfThreadEnd, info.getThreadId());
//            // elapsedCpu is in ns
//            //此段时间内线程占用cpu的时间,ns 单位
//            //时间段（纳秒）=当前耗时-第一次耗时
//            //elapsedTime * 1000000f * nrCPUs 代表着cpu的所有时间
//            //elapsedCpu 代表着这个线程所占有的时间
//            double cpuUsage = delta / (elapsedTime * 1000000f * nrCPUs);
//            threadCPUUsage.put(info.getThreadId() + "-" + info.getThreadName(), String.format("%.2f", cpuUsage));
//        }
//
//        // threadCPUUsage contains cpu % per thread
//        System.out.println("threadCPUUsage:");
//        System.out.println(threadCPUUsage);
//
//        // You can use osMxBean.getThreadInfo(theadId) to get information on
//        // every thread reported in threadCPUUsage and analyze the most CPU
//        // intentive threads
//
//    }
//
//    /**
//     * 返回的前后差距是纳秒
//     *
//     * @param cpuTimeOfThreadStart
//     * @param cpuTimeOfThreadEnd
//     * @param threadId
//     * @return
//     */
//    public Long calculateDelta(Map<Long, Long> cpuTimeOfThreadStart, Map<Long, Long> cpuTimeOfThreadEnd, Long threadId) {
//        Long cpuTimeStart = cpuTimeOfThreadStart.get(threadId);
//        Long cpuTimeEnd = cpuTimeOfThreadEnd.get(threadId);
//        long delta = cpuTimeEnd - cpuTimeStart;
//        return delta;
//    }
//}