package org.yyf.javase.io;

import java.io.*;
import java.util.Arrays;

/**
 * Created by yeyf on 2014-11-5.
 * */
public class ClassPathFileReader {
    public static void main(String[] args) {
        ClassPathFileReader classPathFileReader = new ClassPathFileReader();
        classPathFileReader.readByChar("fortest.txt");
        classPathFileReader.readByByte("fortest.txt");
        System.out.println(ClassPathFileReader.class.getResource("/"));
        System.out.println(ClassPathFileReader.class.getResource(""));
    }
    public void readByByte(String fileName) {
        InputStream inputStream = this.getClass().getResourceAsStream("/fortest.txt");
        if (inputStream == null) {
            throw new RuntimeException(fileName + " 未找到!");
        }
        byte[] temp = new byte[1024];
        StringBuilder result = new StringBuilder();
        try {
            int i;
            while ((i = inputStream.read(temp)) != -1) {
                result.append(new String(Arrays.copyOfRange(temp, 0, i)));
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void readByChar(String fileName){
        InputStream inputStream = this.getClass().getResourceAsStream("/fortest.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String temp;
        StringBuilder result=new StringBuilder();
        try {
            while((temp=bufferedReader.readLine())!=null) {
                result.append(temp+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(result);
    }
}
