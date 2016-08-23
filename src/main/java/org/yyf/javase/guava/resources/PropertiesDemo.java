package org.yyf.javase.guava.resources;

import com.google.common.io.Resources;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by tobi on 16-8-23.
 */
public class PropertiesDemo {
    public static void main(String[] args) {

        Properties properties = new Properties();

        try (InputStreamReader inputStreamReader = new InputStreamReader(Resources.getResource("test.properties").openStream(), "utf-8")) {
            properties.load(inputStreamReader);
            System.out.println(properties);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
