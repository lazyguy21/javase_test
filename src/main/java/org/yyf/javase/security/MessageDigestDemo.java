package org.yyf.javase.security;

import com.google.common.base.Ascii;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by @author yyf on 2018/8/22.
 */
public class MessageDigestDemo {
  public static void main(String[] args) {
    String bimd5Hex = DigestUtils.md5Hex("111111111111111111111sdaf在V字形从V字形从是秩序下次V字形从V字形从V型从v"
            + "");
//    System.out.println(md5Hex);



  }

  @Test
  public void sha() throws NoSuchAlgorithmException {
    MessageDigest sha = MessageDigest.getInstance("sha-512");
    String orgin = "你好，我是原本的信息~阿道夫";
    byte[] digest = sha.digest(orgin.getBytes());
    String hexDigest = Hex.encodeHexString(digest);
    System.out.println(hexDigest);

//commons-codec
    String s = DigestUtils.sha512Hex(orgin);
    System.out.println(s);
  }

  @Test
  public void mac() throws NoSuchAlgorithmException, InvalidKeyException {
    String orgin = "你好，我是原本的信息~阿道夫";

    KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
    SecretKey secretKey = keyGenerator.generateKey();
    byte[] keyContent = secretKey.getEncoded();

    //还原密钥
    SecretKeySpec key = new SecretKeySpec(keyContent, "HmacMD5");
    Mac hmacMD5 = Mac.getInstance(key.getAlgorithm());
    hmacMD5.init(key);
    byte[] digest = hmacMD5.doFinal(orgin.getBytes());
  }
}
