package org.yyf.javase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tobi on 16-5-26.
 */
public class RegTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^/test/.*");
        Matcher matcher = pattern.matcher("/test/testT");
        boolean matches = matcher.matches();
        System.out.println(matches);
    }
}
