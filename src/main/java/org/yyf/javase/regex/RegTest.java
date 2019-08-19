package org.yyf.javase.regex;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tobi on 16-5-26.
 */
public class RegTest {
    private static String test;

    @BeforeClass
    public static void beforeClass(){
        test = "abdfasdcasldkr123kj1l2阿斯蒂芬";
    }
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^/test/.*");
        Matcher matcher = pattern.matcher("/test/testT");
        boolean matches = matcher.matches();
        System.out.println(matches);
    }
    @Test
    public void lineHead(){
//        Matcher matcher = Pattern.compile("^abc").matcher(test);//false
        Matcher matcher = Pattern.compile("^abdfasdca").matcher(test);//false
        boolean matches = matcher.matches();
        System.out.println(matches);

    }

    @Test
    public void or(){//字符组
//        Matcher matcher = Pattern.compile("^abc").matcher(test);//false
        String name = "abcde";
        String name2 = "abce";
        String name3 = "abcde";
        String name4 = "abCe";
        Matcher matcher = Pattern.compile("ab[cd]e").matcher(name4);//false
        boolean matches = matcher.matches();
//        matcher.appendReplacement()
        System.out.println(matches);

    }

    @Test
    public void start() {
       Pattern pattern= Pattern.compile("\\.com+");
      Matcher matcher = pattern.matcher(".commmmm");
      boolean matches = matcher.matches();
      System.out.println(matches);
    }

  @Test
  public void t() {
//  花括号 开头,除了/以外的任何字符一个或多个,最后接花括号
    Pattern pattern = Pattern.compile("\\{[^/]+?\\}");
    String src = "{adfadf}";
    boolean matches = pattern.matcher(src).matches();
    System.out.println(matches);
  }
}
