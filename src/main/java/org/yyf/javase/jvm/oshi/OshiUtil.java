package org.yyf.javase.jvm.oshi;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by @author yyf on 2019-06-26.
 */
public class OshiUtil {
    private static final SystemInfo si;

    static {
        si = new SystemInfo();
    }

    public static Map<String, Map<String, String>> getInfo() {
        Map<String, Map<String, String>> total = new HashMap<>();

        total.put("cpuInfo", getCpuInfo(si.getHardware().getProcessor()));
        total.put("memoryInfo", getMemoryInfo(si.getHardware().getMemory()));

        return total;
    }

    /**
     * 系统的内存信息
     *
     * @param memory
     * @return
     */
    public static Map<String, String> getMemoryInfo(GlobalMemory memory) {
        Map map = new HashMap();
        map.put("memoryAvailable", FormatUtil.formatBytes(memory.getAvailable()));
        map.put("memoryTotal", FormatUtil.formatBytes(memory.getTotal()));
        //当前使用的swap空间
        map.put("swapUsed", FormatUtil.formatBytes(memory.getSwapUsed()));
        map.put("swapTotal", FormatUtil.formatBytes(memory.getSwapTotal()));
        return map;
    }

    /**
     * CPU信息
     *
     * @param processor
     * @return
     */
    public static Map<String, String> getCpuInfo(CentralProcessor processor) {
        Map map = new HashMap();
        map.put("physicalProcessorCount", processor.getPhysicalProcessorCount());
        map.put("logicalProcessorCount", processor.getLogicalProcessorCount());
        map.put("SystemUptime", FormatUtil.formatElapsedSecs(processor.getSystemUptime()));
        map.put("contextSwitches", processor.getContextSwitches());
        map.put("interrupts", processor.getInterrupts());
        map.put("systemLoadAverage", Arrays.toString(processor.getSystemLoadAverage(3)));
        return map;
    }
}
