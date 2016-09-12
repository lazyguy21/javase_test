package org.yyf.javase.baseType;

/**
 * Created by tobi on 16-9-12.
 */
public class IntegerEqual {
    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1.equals(i2));
        System.out.println(i1==i2);//原始类型的包装对象用==比的是引用
        System.out.println(i1==1);


        //数值在-128到127内的Integer对象==比较会相等，其他Integer则不等,这是常量池的缓存范围
        Integer i3 = 300;
        Integer i4 = 300;
        System.out.println(i3==i4);
        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5==i6);
    }
}
