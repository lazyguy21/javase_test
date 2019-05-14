package org.yyf.javase.i18n;

import java.math.BigDecimal;

/**
 * Created by @author yyf on 2018/4/27.
 */
public class T {
  public static void main(String[] args) {
    BigDecimal applyAmount = new BigDecimal(80000);
    BigDecimal daysOfYear = new BigDecimal(360);
    BigDecimal rate = new BigDecimal("0.0700");
    Integer period = 15;
    System.out.println(rate);
    //预计到账金额=申请贴现金额/（1+年化利率/360*贴现期限），然后舍掉不足100元的部分
//    BigDecimal dayRate = rate.divide(daysOfYear, 10, BigDecimal.ROUND_DOWN);
//    BigDecimal t = dayRate.multiply(new BigDecimal(period)).add(new BigDecimal(1));
//    System.out.println(t);
//    BigDecimal loanAmount = applyAmount.divide(
//        t,10, BigDecimal.ROUND_DOWN);
//    System.out.println(loanAmount);
//    BigDecimal bigDecimal = loanAmount.divide(new BigDecimal(100),0, BigDecimal.ROUND_DOWN)
//        .multiply(new BigDecimal(100));
//    System.out.println(bigDecimal);



    //小数点右边10位的计算结果
    BigDecimal loanAmount = applyAmount.divide(
        rate.divide(daysOfYear, 10, BigDecimal.ROUND_DOWN).multiply(new BigDecimal(period)).add(new BigDecimal(1)),
        10,BigDecimal.ROUND_DOWN);

    //只保留百位以上额度
    BigDecimal loanAmountOfHundred =
        loanAmount.divide(new BigDecimal(100), 0, BigDecimal.ROUND_DOWN).multiply(new BigDecimal(100));

    System.out.println(loanAmount);
    System.out.println(loanAmountOfHundred);
  }
}
