package org.yyf.javase.guava.io;

import com.google.common.io.ByteStreams;
import com.google.common.io.CharSource;
import com.google.common.io.CharStreams;
import com.google.common.io.Resources;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

/**
 * Created by tobi on 16-10-19.
 */
public class IOTest {

    private static URL resource;

    @BeforeClass
    public static void beforeClass(){
        resource = Resources.getResource("fortest.txt");
    }
    @Test
    public void testToByteArray() {
        try(InputStream inputStream = resource.openStream()) {
            byte[] bytes = ByteStreams.toByteArray(inputStream);//将inputStream转为ｂｙｔｅ数组，注意需要自己关inputStream
            String s = new String(bytes);
            System.out.println(s);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Test
    public void testToString(){
        try (InputStreamReader reader=new InputStreamReader(resource.openStream())){
            String s = CharStreams.toString(reader);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testReadLines(){
        try (InputStreamReader reader = new InputStreamReader(resource.openStream())) {
            List<String> strings = CharStreams.readLines(reader);
            System.out.println(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSource(){
        Files.as
    }
}
