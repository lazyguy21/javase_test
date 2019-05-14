package org.yyf.javase.security;


import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
/** * RSA算法加密和解密 * */
public class Password_Test {
    public static void main(String[] args) {
        try {
            new Password_Test();
            Encryption_RSA();
            Decryption_RSA();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Password_Test() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");// 生成实现RSA算法的KeyPairGenerator对象
        kpg.initialize(1024);// 初始化确定密钥的大小
        KeyPair kp = kpg.generateKeyPair();// 生成密钥对
        PublicKey pbkey = kp.getPublic();// 创建公钥
        PrivateKey prkey = kp.getPrivate();// 创建私钥
      byte[] encoded = pbkey.getEncoded();
      System.out.println(Base64.encodeBase64String(pbkey.getEncoded()));
        System.out.println(Base64.encodeBase64String(prkey.getEncoded()));
      /* 保存公钥和私钥 */
        // 保存公钥
        FileOutputStream file1 = new FileOutputStream("Skey_RSA_pub.dat");
        ObjectOutputStream ob1 = new ObjectOutputStream(file1);// 创建ObjectOutputStream
        ob1.writeObject(pbkey);
        // 保存私钥
        FileOutputStream file2 = new FileOutputStream("Skey_RSA_priv.dat");
        ObjectOutputStream ob2 = new ObjectOutputStream(file2);// 创建ObjectOutputStream
        ob2.writeObject(prkey);
        //关闭流
        ob1.close();
        ob2.close();
    }
    public static void Encryption_RSA() throws Exception{
        System.out.println("根据公钥生成密文:");
        String string="I am a student";
        //获取公钥
        FileInputStream f_in=new FileInputStream("Skey_RSA_pub.dat");
        ObjectInputStream o_in=new ObjectInputStream(f_in);
        RSAPublicKey pbk=(RSAPublicKey) o_in.readObject();  
        //获取参数e,n
        BigInteger e=pbk.getPublicExponent();//返回此公钥的指数
        BigInteger n=pbk.getModulus();//返回此公钥的模
        System.out.println("公钥的指数 e="+e);
        System.out.println("公钥的模 n="+n);
        //明文 bit
        byte bt[]=string.getBytes("UTF8");
        BigInteger bit=new BigInteger(bt);
        //计算密文c,打印
        BigInteger c=bit.modPow(e, n);
        System.out.println("生成密文为： "+ c+"\n");
        //保存密文
        String save=c.toString();
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Enc_RSA.dat")));//保存密文
        out.write(save, 0, save.length());
        o_in.close();
        out.close();
    }
    public static void Decryption_RSA() throws Exception{
        System.out.println("根据私钥破解密文");
        //读取密文
        BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream("Enc_RSA.dat")));
        String  ctext=in.readLine();
        BigInteger d=new BigInteger(ctext);
        //读取私钥
        FileInputStream f=new FileInputStream("Skey_RSA_priv.dat");
        ObjectInputStream b=new ObjectInputStream(f);
        RSAPrivateKey prk=(RSAPrivateKey) b.readObject();
        //获取私钥指数和模
        BigInteger e=prk.getPrivateExponent();//返回私钥的指数
        BigInteger m=prk.getModulus();//返回私钥的模
        BigInteger jie=d.modPow(e, m);
        System.out.println("私钥的指数 e= "+e);
        System.out.println("私钥的模 m="+m);
        System.out.println("解密结果 ： "+jie);
        byte mt[]=jie.toByteArray();
        System.out.print("解密后的文本内容为： ");
        for (int i = 0; i < mt.length; i++) {
            System.out.print((char)mt[i]);
        }
        in.close();
        b.close();
    }
}