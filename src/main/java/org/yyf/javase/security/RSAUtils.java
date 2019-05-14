//package org.yyf.javase.security;
//
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
//import java.math.BigInteger;
//import java.security.Key;
//import java.security.KeyFactory;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.RSAPrivateKeySpec;
//import java.security.spec.RSAPublicKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.crypto.Cipher;
//
//
///**
// * RSA私钥公钥字符串、对象生成工具
// *
// * 本工具类提供以下几种方法：
// *
// * 1、生成基于PublicKey 和PrivateKey对象的方法 initRSAKeys() 2、将PrivateKey对象转为私钥字符串
// * 3、将PublicKey对象转为公钥字符串 4、将私钥字符串转为PrivateKey对象 5、将公钥字符串转为PublicKey对象
// * 6、将公钥和私钥以文件形式保存
// *
// * @author Guo pengFei
// *
// * @date 2017-7-27
// *
// * @version V1.0
// *
// * @compeny 深证风轮科技有限公司
// *
// * @site https://www.blog-china.cn
// *
// */
//public class RSAUtils {
//	/** 指定加密算法为RSA */
//	private static final String ALGORITHM = "RSA";
//	/** 指定公钥存放文件 */
//	private static String PUBLIC_KEY_FILE = "D://key/PublicKey.txt";
//	/** 指定私钥存放文件 */
//	private static String PRIVATE_KEY_FILE = "D://key/PrivateKey.txt";
//
//	/**
//	 * 以文件形式生成公钥和私钥，并保存
//	 *
//	 * @return
//	 * @throws Exception
//	 */
//	@SuppressWarnings({ "finally", "resource" })
//	public static boolean writeKeyFile() throws Exception {
//		Map<String, Object> map = initRSAKeys();
//		Key publicKey = (Key) map.get("pubKey");
//		Key privateKey = (Key) map.get("priKey");
//
//		String pubKeyString = RSAUtils.getKeyString(publicKey);
//
//		String priKeyString = RSAUtils.getKeyString(privateKey);
//		System.out.println(pubKeyString);
//		System.out.println();
//		System.out.println(priKeyString);
//
//		/** 用对象流将生成的密钥写入文件 */
//		FileOutputStream oos1 = new FileOutputStream(PUBLIC_KEY_FILE);
//		oos1.write(pubKeyString.getBytes("UTF-8")); // 可以指定编码
//
//		FileOutputStream oos2 = new FileOutputStream(PRIVATE_KEY_FILE);
//		oos2.write(priKeyString.getBytes("UTF-8")); // 可以指定编码
//
//		/** 清空缓存，关闭文件输出流 */
//		if (oos1 != null) {
//			oos1.close();
//		}
//		if (oos2 != null) {
//			oos2.close();
//		}
//		return true;
//	}
//
//	/**
//	 * 生产RSA的私钥和公钥
//	 *
//	 * @return
//	 * @throws NoSuchAlgorithmException
//	 */
//	public static Map<String, Object> initRSAKeys()
//			throws NoSuchAlgorithmException {
//		Map<String, Object> map = getKeys();
//		// 生成公钥和私钥
//		RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
//		RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
//
//		// 模
//		String modulus = publicKey.getModulus().toString();
//		// 公钥指数
//		String public_exponent = publicKey.getPublicExponent().toString();
//		// 私钥指数
//		String private_exponent = privateKey.getPrivateExponent().toString();
//		// 使用模和指数生成公钥和私钥
//		RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
//		RSAPrivateKey priKey = RSAUtils
//				.getPrivateKey(modulus, private_exponent);
//
//		map.put("pubKey", pubKey);
//		map.put("priKey", priKey);
//		return map;
//	}
//
//	/**
//	 * 把公钥字符串转为对象
//	 *
//	 * @param key
//	 * @return
//	 * @throws Exception
//	 */
//	public static PublicKey getPublicKey(String key) throws Exception {
//		byte[] keyBytes;
//		keyBytes = (new BASE64Decoder()).decodeBuffer(key);
//		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
//		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//		PublicKey publicKey = keyFactory.generatePublic(keySpec);
//		return publicKey;
//	}
//
//	/**
//	 * 把私钥字符串转为对象
//	 *
//	 * @param key
//	 * @return
//	 * @throws Exception
//	 */
//	public static PrivateKey getPrivateKey(String key) throws Exception {
//		byte[] keyBytes;
//		keyBytes = (new BASE64Decoder()).decodeBuffer(key);
//		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
//		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
//		PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
//		return privateKey;
//	}
//
//	/**
//	 * 得到密钥字符串（经过base64编码）
//	 *
//	 * @return
//	 */
//	public static String getKeyString(Key key) throws Exception {
//		byte[] keyBytes = key.getEncoded();
//		String s = (new BASE64Encoder()).encode(keyBytes);
//		return s;
//	}
//
//	/**
//	 * 生成公钥和私钥
//	 *
//	 * @throws NoSuchAlgorithmException
//	 *
//	 */
//	private static HashMap<String, Object> getKeys()
//			throws NoSuchAlgorithmException {
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
//		keyPairGen.initialize(1024);
//		KeyPair keyPair = keyPairGen.generateKeyPair();
//		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//		map.put("public", publicKey);
//		map.put("private", privateKey);
//		return map;
//	}
//
//	/**
//	 * 使用模和指数生成RSA公钥
//	 * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
//	 * /None/NoPadding】
//	 *
//	 * @param modulus
//	 *            模
//	 * @param exponent
//	 *            指数
//	 * @return
//	 */
//	private static RSAPublicKey getPublicKey(String modulus, String exponent) {
//		try {
//			BigInteger b1 = new BigInteger(modulus);
//			BigInteger b2 = new BigInteger(exponent);
//			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
//			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
//			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	/**
//	 * 使用模和指数生成RSA私钥
//	 * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
//	 * /None/NoPadding】
//	 *
//	 * @param modulus
//	 *            模
//	 * @param exponent
//	 *            指数
//	 * @return
//	 */
//	private static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
//		try {
//			BigInteger b1 = new BigInteger(modulus);
//			BigInteger b2 = new BigInteger(exponent);
//			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
//			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
//			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	/**
//	 * 公钥加密
//	 *
//	 * @param data
//	 * @param publicKey
//	 * @return
//	 * @throws Exception
//	 */
//	public static String encryptByPublicKey(String data, RSAPublicKey publicKey)
//			throws Exception {
//		Cipher cipher = Cipher.getInstance(ALGORITHM);
//		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//		// 模长
//		int key_len = publicKey.getModulus().bitLength() / 8;
//		// 加密数据长度 <= 模长-11
//		String[] datas = splitString(data, key_len - 11);
//		String mi = "";
//		// 如果明文长度大于模长-11则要分组加密
//		for (String s : datas) {
//			mi += bcd2Str(cipher.doFinal(s.getBytes()));
//		}
//		return mi;
//	}
//
//	/**
//	 * 私钥解密
//	 *
//	 * @param data
//	 * @param privateKey
//	 * @return
//	 * @throws Exception
//	 */
//	public static String decryptByPrivateKey(String data,
//			RSAPrivateKey privateKey) throws Exception {
//		Cipher cipher = Cipher.getInstance(ALGORITHM);
//		cipher.init(Cipher.DECRYPT_MODE, privateKey);
//		// 模长
//		int key_len = privateKey.getModulus().bitLength() / 8;
//		byte[] bytes = data.getBytes();
//		byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
//		System.err.println(bcd.length);
//		// 如果密文长度大于模长则要分组解密
//		String ming = "";
//		byte[][] arrays = splitArray(bcd, key_len);
//		for (byte[] arr : arrays) {
//			ming += new String(cipher.doFinal(arr));
//		}
//		return ming;
//	}
//
//	/**
//	 * ASCII码转BCD码
//	 *
//	 */
//	private static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
//		byte[] bcd = new byte[asc_len / 2];
//		int j = 0;
//		for (int i = 0; i < (asc_len + 1) / 2; i++) {
//			bcd[i] = asc_to_bcd(ascii[j++]);
//			bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
//		}
//		return bcd;
//	}
//
//	private static byte asc_to_bcd(byte asc) {
//		byte bcd;
//
//      if ((asc >= '0') && (asc <= '9')) {
//        bcd = (byte) (asc - '0');
//      } else if ((asc >= 'A') && (asc <= 'F')) {
//        bcd = (byte) (asc - 'A' + 10);
//      } else if ((asc >= 'a') && (asc <= 'f')) {
//        bcd = (byte) (asc - 'a' + 10);
//      } else {
//        bcd = (byte) (asc - 48);
//      }
//		return bcd;
//	}
//
//	/**
//	 * BCD转字符串
//	 */
//	private static String bcd2Str(byte[] bytes) {
//		char temp[] = new char[bytes.length * 2], val;
//
//		for (int i = 0; i < bytes.length; i++) {
//			val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
//			temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
//
//			val = (char) (bytes[i] & 0x0f);
//			temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
//		}
//		return new String(temp);
//	}
//
//	/**
//	 * 拆分字符串
//	 */
//	private static String[] splitString(String string, int len) {
//		int x = string.length() / len;
//		int y = string.length() % len;
//		int z = 0;
//		if (y != 0) {
//			z = 1;
//		}
//		String[] strings = new String[x + z];
//		String str = "";
//		for (int i = 0; i < x + z; i++) {
//			if (i == x + z - 1 && y != 0) {
//				str = string.substring(i * len, i * len + y);
//			} else {
//				str = string.substring(i * len, i * len + len);
//			}
//			strings[i] = str;
//		}
//		return strings;
//	}
//
//	/**
//	 * 拆分数组
//	 */
//	private static byte[][] splitArray(byte[] data, int len) {
//		int x = data.length / len;
//		int y = data.length % len;
//		int z = 0;
//		if (y != 0) {
//			z = 1;
//		}
//		byte[][] arrays = new byte[x + z][];
//		byte[] arr;
//		for (int i = 0; i < x + z; i++) {
//			arr = new byte[len];
//			if (i == x + z - 1 && y != 0) {
//				System.arraycopy(data, i * len, arr, 0, y);
//			} else {
//				System.arraycopy(data, i * len, arr, 0, len);
//			}
//			arrays[i] = arr;
//		}
//		return arrays;
//	}
//}