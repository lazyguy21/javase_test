package org.yyf.javase.guava.resources;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;

import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by tobi on 16-10-10.
 */
public class TestM {

    @Test
    public void LoadResourceToString(){
        try {
            String s;
            URL resourceUrl = Resources.getResource("fortest.txt");
            s = Resources.toString(resourceUrl, Charset.defaultCharset());
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
