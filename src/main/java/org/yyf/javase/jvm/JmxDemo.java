package org.yyf.javase.jvm;

import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

/**
 * Created by @author yyf on 2019-06-16.
 */
public class JmxDemo {
    public static void main(String[] args) {
//        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
//        List<String> inputArguments = runtimeMXBean.getInputArguments();
//        System.out.println(inputArguments);
//
        HotSpotDiagnosticMXBean platformMXBean = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
        List<VMOption> diagnosticOptions = platformMXBean.getDiagnosticOptions();
        diagnosticOptions.forEach(System.out::println);
        VMOption vmOption = platformMXBean.getVMOption("PrintFlagsFinal");
        VMOption vmOption2 = platformMXBean.getVMOption("UseMaximumCompactionOnSystemGC");
        System.out.println(vmOption);
        System.out.println(vmOption2);
//        VMUtil.t();
    }
}
