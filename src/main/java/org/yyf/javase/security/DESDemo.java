package org.yyf.javase.security;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

/**
 * Created by @author yyf on 2019-04-03.
 */
public class DESDemo {
    @Test
    public void d() throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(56);
        SecretKey secretKey = kg.generateKey();
    }
}
