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
}
