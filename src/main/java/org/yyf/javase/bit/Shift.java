package org.yyf.javase.bit;

public class Shift {
    public static void main(String[] args) {
        int ac = 0x01;
//    int b = a << 4;
//    System.out.println(a);
//    System.out.println(b);
//
//
//    System.out.println(1<<4);
//    System.out.println(-1 << 4);
//    System.out.println(Integer.toBinaryString(-1));

        int a = 0b101;
        System.out.println("a=" + a);
        //位移运算符就是每一个位上的1往前移动一位，既乘以二，所以<<既该数乘以二。
        int b = a << 1;
        System.out.println(b);
        int c = a << 2;
        System.out.println(c);
        int negativeA = -5;
        System.out.println("-5:"+Integer.toBinaryString(negativeA));
        System.out.println(a>>1);
        System.out.println();

        System.out.println("a toBinaryString:"+Integer.toBinaryString(a));
        System.out.println(negativeA >>> 1);
        int negativeB = -5;
        System.out.println(negativeB >>> 1);

    }
}
