//import java.security.Key;
//import java.security.KeyFactory;
//import java.security.KeyPair;
//import java.security.KeyPairGenerator;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.PublicKey;
//import java.security.SecureRandom;
//import java.security.interfaces.RSAPrivateKey;
//import java.security.interfaces.RSAPublicKey;
//import java.security.spec.InvalidKeySpecException;
//import java.security.spec.PKCS8EncodedKeySpec;
//import java.security.spec.X509EncodedKeySpec;
//import javax.crypto.Cipher;
//import org.apache.commons.configuration.ConfigurationException;
//import org.apache.commons.configuration.PropertiesConfiguration;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;
//
//public class RSATest {
//
//  public static void main(String[] args) {
//    try {
//      RSATest encrypt = new RSATest();
//      String encryptText = "encryptText";
//
//      // Generate keys
//      KeyPair keyPair = encrypt.generateKey();
//      RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//      RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//
//      byte[] e = encrypt.encrypt(publicKey, encryptText.getBytes());
//      byte[] de = encrypt.decrypt(privateKey, e);
//      System.out.println(toHexString(e));
//      System.out.println(toHexString(de));
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public KeyPair generateKey() throws NoSuchAlgorithmException {
//    KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
//    keyPairGen.initialize(1024, new SecureRandom());
//
//    KeyPair keyPair = keyPairGen.generateKeyPair();
//    return keyPair;
//  }
//
//  public void saveKey(KeyPair keyPair, String publicKeyFile,
//      String privateKeyFile) throws ConfigurationException {
//    PublicKey pubkey = keyPair.getPublic();
//    PrivateKey prikey = keyPair.getPrivate();
//
//    // save public key
//    PropertiesConfiguration publicConfig = new PropertiesConfiguration(
//        publicKeyFile);
//    publicConfig.setProperty("PULIICKEY", toHexString(pubkey.getEncoded()));
//    publicConfig.save();
//
//    // save private key
//    PropertiesConfiguration privateConfig = new PropertiesConfiguration(
//        privateKeyFile);
//    privateConfig.setProperty("PRIVATEKEY",
//        toHexString(prikey.getEncoded()));
//    privateConfig.save();
//  }
//
//  /**
//   * @param filename
//   * @param type：
//   *            1-public 0-private
//   * @return
//   * @throws ConfigurationException
//   * @throws NoSuchAlgorithmException
//   * @throws InvalidKeySpecException
//   */
//  public Key loadKey(String filename, int type)
//      throws ConfigurationException, NoSuchAlgorithmException,
//      InvalidKeySpecException {
//    PropertiesConfiguration config = new PropertiesConfiguration(filename);
//    KeyFactory keyFactory = KeyFactory.getInstance("RSA",
//        new BouncyCastleProvider());
//
//    if (type == 0) {
//      // privateKey
//      String privateKeyValue = config.getString("PULIICKEY");
//      PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
//          toBytes(privateKeyValue));
//      PrivateKey privateKey = keyFactory.generatePrivate(priPKCS8);
//      return privateKey;
//
//    } else {
//      // publicKey
//      String privateKeyValue = config.getString("PRIVATEKEY");
//      X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(
//          toBytes(privateKeyValue));
//      PublicKey publicKey = keyFactory.generatePublic(bobPubKeySpec);
//      return publicKey;
//    }
//  }
//
//  /**
//   * Encrypt String.
//   *
//   * @return byte[]
//   */
//  protected byte[] encrypt(RSAPublicKey publicKey, byte[] data) {
//    if (publicKey != null) {
//      try {
//        Cipher cipher = Cipher.getInstance("RSA",
//            new BouncyCastleProvider());
//        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
//        return cipher.doFinal(data);
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//    }
//    return null;
//  }
//
//  /**
//   * Basic decrypt method
//   *
//   * @return byte[]
//   */
//  protected byte[] decrypt(RSAPrivateKey privateKey, byte[] raw) {
//    if (privateKey != null) {
//      try {
//        Cipher cipher = Cipher.getInstance("RSA",
//            new BouncyCastleProvider());
//        cipher.init(Cipher.DECRYPT_MODE, privateKey);
//        return cipher.doFinal(raw);
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//    }
//
//    return null;
//  }
//
//  public static String toHexString(byte[] b) {
//    StringBuilder sb = new StringBuilder(b.length * 2);
//    for (int i = 0; i < b.length; i++) {
//      sb.append(HEXCHAR[(b[i] & 0xf0) >>> 4]);
//      sb.append(HEXCHAR[b[i] & 0x0f]);
//    }
//    return sb.toString();
//  }
//
//  public static final byte[] toBytes(String s) {
//    byte[] bytes;
//    bytes = new byte[s.length() / 2];
//    for (int i = 0; i < bytes.length; i++) {
//      bytes[i] = (byte) Integer.parseInt(s.substring(2 * i, 2 * i + 2),
//          16);
//    }
//    return bytes;
//  }
//
//  private static char[] HEXCHAR = { '0', '1', '2', '3', '4', '5', '6', '7',
//      '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
//
//}