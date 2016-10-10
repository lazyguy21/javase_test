package org.yyf.javase.guava.resources;

import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;
import com.google.common.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by tobi on 16-8-23.
 */
public class ResourcesDemo {
    public static void main(String[] args) {
        URL resource = Resources.getResource("fortest.txt");
        try {
            InputStream inputStream = resource.openStream();
            String s = new String(ByteStreams.toByteArray(inputStream), Charsets.UTF_8);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
