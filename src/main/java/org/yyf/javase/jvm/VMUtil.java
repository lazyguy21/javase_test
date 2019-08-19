package org.yyf.javase.jvm;

import com.sun.management.HotSpotDiagnosticMXBean;
import com.sun.management.VMOption;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by @author yyf on 2019-06-16.
 */
public class VMUtil {
    public static void main(String[] args) {
//        Properties properties = VMUtil.getProperties();
//        System.out.println(properties);
        Properties properties1 = VMUtil.getProperties();
        System.out.println(properties1);
    }
//    public static void t() {
////        -Xmx250m   -XX:+PrintFlagsFinal -XX:+UnlockDiagnosticVMOptions -XX:+UnlockExperimentalVMOptions
//        // load the diagnostic bean first to avoid UnsatisfiedLinkError
//        final HotSpotDiagnosticMXBean hsdiag = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
//        List<VMOption> options;
//        try {
//            final Class<?> flagClass = Class.forName("sun.management.Flag");
//            final Method getAllFlagsMethod = flagClass.getDeclaredMethod("getAllFlags");
//            final Method getVMOptionMethod = flagClass.getDeclaredMethod("getVMOption");
//            getAllFlagsMethod.setAccessible(true);
//            getVMOptionMethod.setAccessible(true);
//            final Object result = getAllFlagsMethod.invoke(null);
//            final List<?> flags = (List<?>) result;
//            options = new ArrayList<VMOption>(flags.size());
//            for (final Object flag : flags) {
//                options.add((VMOption) getVMOptionMethod.invoke(flag));
//            }
//        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
//                | InvocationTargetException | ClassCastException e) {
//            if (hsdiag != null) {
//                // only includes writable external flags
//                options = hsdiag.getDiagnosticOptions();
//            } else {
//                options = Collections.emptyList();
//            }
//        }
//        final Map<String, VMOption> optionMap = new TreeMap<>();
//        for (final VMOption option : options) {
//            optionMap.put(option.getName(), option);
//        }
//        for (final VMOption option : optionMap.values()) {
//            System.out.println(option.getName() + " = " + option.getValue() + " (" +
//                    option.getOrigin() + ", " +
//                    (option.isWriteable() ? "read-write" : "read-only") + ")");
//        }
//        System.out.println(options.size() + " options found");
//    }

    public static Properties getProperties() {
        Properties properties = System.getProperties();
        return properties;
    }

    public static List<VMOption> getAllVMOption() {
        final HotSpotDiagnosticMXBean hsdiag = ManagementFactory.getPlatformMXBean(HotSpotDiagnosticMXBean.class);
        List<VMOption> options;
        try {
            final Class<?> flagClass = Class.forName("sun.management.Flag");
            final Method getAllFlagsMethod = flagClass.getDeclaredMethod("getAllFlags");
            final Method getVMOptionMethod = flagClass.getDeclaredMethod("getVMOption");
            getAllFlagsMethod.setAccessible(true);
            getVMOptionMethod.setAccessible(true);
            final Object result = getAllFlagsMethod.invoke(null);
            final List<?> flags = (List<?>) result;
            options = new ArrayList<VMOption>(flags.size());
            for (final Object flag : flags) {
                options.add((VMOption) getVMOptionMethod.invoke(flag));
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InvocationTargetException | ClassCastException e) {
            if (hsdiag != null) {
                // only includes writable external flags
                options = hsdiag.getDiagnosticOptions();
            } else {
                options = Collections.emptyList();
            }
        }
        return options;
    }

    public static void getThread() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    }
}
