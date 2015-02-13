package org.yyf.javase.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * aaa
 * Created by yeyf on 2015-2-11.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader bufferedReader) throws IOException;
}
