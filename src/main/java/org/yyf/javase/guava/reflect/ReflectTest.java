package org.yyf.javase.guava.reflect;

import com.google.common.reflect.ClassPath;

import org.junit.Test;
import org.yyf.javase.domain.Animal;

import java.io.IOException;

/**
 * Created by tobi on 16-10-19.
 */
public class ReflectTest {
    @Test
    public void test() throws IOException {
        ClassPath classPath = ClassPath.from(Animal.class.getClassLoader());
        for (ClassPath.ClassInfo classInfo : classPath.getTopLevelClasses("org.yyf.javase.domain")) {
            System.out.println(classInfo);
        }
    }

}
