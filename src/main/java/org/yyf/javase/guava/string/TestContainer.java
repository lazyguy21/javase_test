package org.yyf.javase.guava.string;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tobi on 16-10-19.
 */
public class TestContainer {
    @Test
    public void testJoiner() {
//        List<String> values = Lists.newArrayList("haha", "d", "1");
//        List<String> values = Lists.newArrayList("haha", "d",""," ", "1","");
        List<String> values = Lists.newArrayList("haha", "d", "", null, "1");//null报错
        String join = Joiner.on("|").join(values);
        System.out.println(join);
    }

    @Test
    public void testJoiner２() {
        List<String> values = Lists.newArrayList("haha", "d", "", null, "1");
        String join = Joiner.on("|").skipNulls().join(values);
        System.out.println(join);
    }

    @Test
    public void testSplitter() {
        String source = "|dfa||fadf|123|的|f|人的|";
        String[] split = source.split("\\|");//java的split方法行为非常古怪，分隔符也需要转义，慎用
        System.out.println(Arrays.toString(split));
//        List<String> strings = Splitter.on("|").splitToList(source);
        List<String> strings = Splitter.on("|").omitEmptyStrings().splitToList(source);
        System.out.println(strings);
    }

    @Test
    public void testCharMatchers() {
        String str = "的FirstName LastName +1 123 456 789 !@#$%^&*()_+|}{:\"?><";
        String s = CharMatcher.JAVA_DIGIT.retainFrom(str);//过滤后保留数字
        System.out.println(s);
        String s1 = CharMatcher.JAVA_LETTER.retainFrom(str);
        System.out.println(s1);

        String aeiou = CharMatcher.JAVA_DIGIT.or(CharMatcher.anyOf("aeiou")).retainFrom(str);//"iaeaae1123456789"
        System.out.println(aeiou);

        //去掉控制字符(\t,\n,\b...)
        System.out.println(CharMatcher.JAVA_ISO_CONTROL.removeFrom(str));

//获取所有的数字
        System.out.println(CharMatcher.DIGIT.retainFrom(str));

//把多个空格替换为一个包括\t,并去掉首位的空格
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom(str, ' '));

//把所有的数字用"*"代替
        System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom(str, "*"));

//获取所有的数字和小写字母
        System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(str));

//获取所有的大写字母
        System.out.println(CharMatcher.JAVA_UPPER_CASE.retainFrom(str));

//获取所有单字节长度的符号
        System.out.println(CharMatcher.SINGLE_WIDTH.retainFrom(str));
    }
    @Test
    public void testCharset(){
        String string = "asdf大师傅123";
        byte[] bytes1 = string.getBytes(Charsets.UTF_8);
        try {
            System.out.println(new String(bytes1,"iso-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] bytes = string.getBytes(Charset.forName("utf-8"));
        try {
            System.out.println(new String(bytes,"iso-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] bytes2 = string.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes2));
    }
    @Test
    public void last(){
        String s = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME");// returns "constantName"
        System.out.println(s);

    }
}
