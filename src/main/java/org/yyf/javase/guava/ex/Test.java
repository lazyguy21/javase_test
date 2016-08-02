package org.yyf.javase.guava.ex;

import com.google.common.base.Throwables;

import java.util.List;

/**
 * Created by tobi on 16-8-2.
 */
public class Test {
    public static void main(String[] args) {
        try {
            ex();
        }catch (Exception ex){
            List<Throwable> causalChain = Throwables.getCausalChain(ex);
            String stackTraceAsString = Throwables.getStackTraceAsString(ex);
            System.out.println(causalChain);
            System.out.println(stackTraceAsString);
        }
    }
    public static void ex(){
        RuntimeException runtimeException = new RuntimeException("some reason causing error");
        throw runtimeException;
    }
}
