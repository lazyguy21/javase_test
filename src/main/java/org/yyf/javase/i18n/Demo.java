package org.yyf.javase.i18n;

import java.util.ResourceBundle;

public class Demo {
  public static void main(String[] args) {
    // Java会根据当前系统默认区域获取对应资源，如果没有则使用无区域信息的默认资源
    ResourceBundle res = ResourceBundle.getBundle("i18n/test");
// 通过key-value的方式取得资源内的信息
    String value = res.getString("name");
    System.out.println(value);
  }
}
