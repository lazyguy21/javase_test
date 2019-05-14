package org.yyf.javase.io;

import java.io.*;

/**
 * Created by ye on 15-8-13.
 */
public class FileSaver {
    public static void main(String[] args) throws IOException {
        String str = "testdasdfadf";
        File test = new File("Testt.txt");
        test.createNewFile();
        FileWriter fileWriter = new FileWriter(test);
        fileWriter.write(str.toCharArray());
        fileWriter.close();



    }
}
