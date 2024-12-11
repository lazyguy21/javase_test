//package org.yyf.javase.reflection;
//
//import cn.hutool.core.lang.ClassScaner;
//import java.util.Optional;
//import java.util.Set;
//import org.yyf.javase.enums.BaseEnum;
//
///**
// * Created by @author yyf on 2024/4/28.
// */
//public class ScannerClass {
//
//  public static void main(String[] args) {
//    String enumName="TestEnum";
//    Set<Class<?>> classes = ClassScaner.scanPackage("org.yyf.javase.enums");
//     classes.stream().filter(clazz -> clazz.isEnum())
//        .filter(clz -> BaseEnum.class.isAssignableFrom(clz))
//        .filter(clz -> clz.getSimpleName().equalsIgnoreCase(enumName))
//        .findFirst().ifPresent(clz->{
//           Object[] enumConstants = clz.getEnumConstants();
//           for (Object enumConstant : enumConstants) {
//             BaseEnum baseEnum = (BaseEnum) enumConstant;
//             System.out.println(baseEnum.getLabel());
//             System.out.println(baseEnum.getKey());
//           }
//         });
//
//  }
//
//}
