package org.yyf.javase.security;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by @author yyf on 2018/8/10.
 */
public class RSA {
  public static void generateKeyPair() throws NoSuchAlgorithmException, IOException {
    //1.初始化密钥
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(512);
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
    System.out.println(rsaPublicKey.getEncoded());
    new FileOutputStream("file").write(rsaPublicKey.getEncoded());
//    RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();
//    System.out.println(new String(rsaPrivateKey.getEncoded()));
  }

  public static void main(String[] args) throws Exception {
    //1.初始化密钥
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(512);
    KeyPair keyPair = keyPairGenerator.generateKeyPair();
    RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
    RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();

    //2.执行签名
    PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
    Signature signature = Signature.getInstance("MD5withRSA");
    signature.initSign(privateKey);
    signature.update("阿斯蒂芬".getBytes());
    String signString = Base64.encodeBase64String(signature.sign());
    System.out.println(signString);

    //3.验证签名
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
    keyFactory = KeyFactory.getInstance("RSA");
    PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
    signature = Signature.getInstance("MD5withRSA");
    signature.initVerify(publicKey);
    signature.update("阿斯蒂芬".getBytes());
    boolean bool = signature.verify(Base64.decodeBase64(signString));
    System.out.println("jdk rsa verify : " + bool);
  }
}
