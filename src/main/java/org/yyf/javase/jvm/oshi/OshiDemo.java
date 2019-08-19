//package org.yyf.javase.jvm.oshi;
//
//import org.junit.Test;
//import oshi.SystemInfo;
//import oshi.hardware.HardwareAbstractionLayer;
//import oshi.software.os.OSProcess;
//import oshi.software.os.OperatingSystem;
//
///**
// * Created by @author yyf on 2019-06-26.
// */
//public class OshiDemo {
//    @Test
//    public void t() {
//        SystemInfo si = new SystemInfo();
//        OperatingSystem os = si.getOperatingSystem();
//        System.out.println(os);
//        HardwareAbstractionLayer hal = si.getHardware();
//        System.out.println(hal.getProcessor().length + " CPU(s):");
//        for(Processor cpu : hal.getProcessors()) {
//            System.out.println(" " + cpu);
//        }
//        System.out.println("Memory: " +
//                FormatUtil.formatBytes(hal.getMemory().getAvailable()) + "/" +
//                FormatUtil.formatBytes(hal.getMemory().getTotal()));
//
//    }
//    private double getProcessRecentCpuUsage() {
//        double output = 0d;
//        HardwareAbstractionLayer hal = si.getHardware();
//        OperatingSystem os = si.getOperatingSystem();
//        OSProcess p = os.getProcess(os.getProcessId());
//
//        if (cpuTime != 0) {
//            double uptimeDiff = p.getUpTime() - uptime;
//            double cpuDiff = (p.getKernelTime() + p.getUserTime()) - cpuTime;
//            output = cpuDiff / uptimeDiff;
//        } else {
//            output = ((double) (p.getKernelTime() + p.getUserTime())) / (double) p.getUserTime();
//        }
//
//        // Record for next invocation
//        uptime = p.getUpTime();
//        cpuTime = p.getKernelTime() + p.getUserTime();
//        return output / hal.getProcessor().getLogicalProcessorCount();
//    }
//
//}
