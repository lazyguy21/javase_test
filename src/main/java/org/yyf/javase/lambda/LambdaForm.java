package org.yyf.javase.lambda;

import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Created by tobi on 2017/6/27.
 */
public class LambdaForm {
  @Test
  public void basic() {
    //这就是一个lambda表达式最基本的样子，后续的形式都是从这个形式的基础上演变而来的
    Function<Integer,String> function = (Integer src) -> {
      System.out.println(src);
      return Integer.toString(src);
    };
  }


  @Test
  public void basic2() {
    //跟基本形式比起来这个没有声明参数类型，括号也省了。因为编译器是可以通过左边的变量声明知道是什么类型的
    Function<Integer,String> function = src -> {
      System.out.println(src);
      return Integer.toString(src);
    };
  }

  @Test
  public void basic3() {
    //进一步，如果你的代码块只有一句，也就return xxxx;
    //那么连return 和或括号也省了：
    Function<Integer,String> function = src -> Integer.toString(src);
  }

  @Test
  public void basic4() {
    //当你的lambda表达式就只是利用现有方法的时候，可以直接使用"方法引用"
    Function<Integer,String> function = String::valueOf;
  }


}
