package org.yyf.javase.lambda.functional;

import java.util.Objects;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * Created by @author yyf on 2023/10/3.
 */
public class PredicateDemo {

    @Test
    public void testPredicate() {
        Predicate<String> predicate = s -> s.length() > 5;
        System.out.println(predicate.test("123456"));
        System.out.println(predicate.test("12345"));


        Predicate<Boolean> nonNull = obj -> Objects.nonNull(obj);
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

}
