//package org.yyf.javase.jvm;
//
//import com.sun.management.DiagnosticCommandMBean;
//import org.junit.Test;
//import sun.management.ManagementFactoryHelper;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.util.Arrays;
//import java.util.stream.Collectors;
//
///**
// * Created by @author yyf on 2019-06-21.
// */
//public class DiagnosticDemo {
//    @Test
//    public static String executeDcmd(String cmd, String... args) {
//        DiagnosticCommandMBean dcmd = ManagementFactoryHelper.getDiagnosticCommandMBean();
//        Object[] dcmdArgs = {args};
//        String[] signature = {String[].class.getName()};
//
//        String cmdString = cmd + " " +
//                Arrays.stream(args).collect(Collectors.joining(" "));
//        File f = new File("dcmdoutput-" + cmd + "-" + System.currentTimeMillis() + ".txt");
//        System.out.println("Output from Dcmd '" + cmdString + "' is being written to file " + f);
//        try (FileWriter fw = new FileWriter(f)) {
//            fw.write("> " + cmdString + ":");
//            String result = (String) dcmd.invoke(cmd, dcmdArgs, signature);
//            fw.write(result);
//            return result;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return null;
//    }
//}
//
