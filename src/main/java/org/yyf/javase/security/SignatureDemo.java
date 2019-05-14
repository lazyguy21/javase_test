package org.yyf.javase.security;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import java.security.*;

/**
 * Created by @author yyf on 2019-04-03.
 */
public class SignatureDemo {
    @Test
    public void ke() throws NoSuchAlgorithmException {
        KeyPairGenerator kg = KeyPairGenerator.getInstance("MD5withRSA");
        KeyPair keyPair = kg.genKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] encoded = publicKey.getEncoded();
        String hexPublicKey = Hex.encodeHexString(encoded);
        System.out.println(hexPublicKey);
        String hexPrivateKey = Hex.encodeHexString(privateKey.getEncoded());
        System.out.println(hexPrivateKey);
    }
}
