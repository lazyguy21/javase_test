package org.yyf.javase.serialize;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by tobi on 16-7-26.
 */
public class ClientA {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setAge(19);
//        new ObjectOutputStream()
        ObjectOutputStream oo = new ObjectOutputStream  (new FileOutputStream(new File("test.txt")));
        oo.writeObject(user);

    }

}
