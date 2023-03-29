package com.evoter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class EncryptionSecure {

    public void doEncryption() throws Exception {
        // Step 1: Generate RSA Key Pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        // Step 2: Encrypt AES Key with RSA Public Key
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        SecretKey aesKey = generateAESKey();
        byte[] encryptedAesKey = rsaCipher.doFinal(aesKey.getEncoded());

        // Step 3: Encrypt Election Data with AES Key
        Cipher aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[16]; // initialization vector
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey, ivSpec);
        byte[] encryptedData = aesCipher.doFinal("Election Data".getBytes());

        // Step 4: Decrypt AES Key with RSA Private Key
        rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedAesKey = rsaCipher.doFinal(encryptedAesKey);
        SecretKey decryptedAesKeyObj = new SecretKeySpec(decryptedAesKey, 0, decryptedAesKey.length, "AES");

        // Step 5: Decrypt Election Data with AES Key
        aesCipher.init(Cipher.DECRYPT_MODE, decryptedAesKeyObj, ivSpec);
        byte[] decryptedData = aesCipher.doFinal(encryptedData);

        System.out.println(new String(decryptedData));
    }

    public void doDecryption() {
        // Step 4: Decrypt AES Key with RSA Private Key
//        rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
//        byte[] decryptedAesKey = rsaCipher.doFinal(encryptedAesKey);
//        SecretKey decryptedAesKeyObj = new SecretKeySpec(decryptedAesKey, 0, decryptedAesKey.length, "AES");
//
//        // Step 5: Decrypt Election Data with AES Key
//        aesCipher.init(Cipher.DECRYPT_MODE, decryptedAesKeyObj, ivSpec);
//        byte[] decryptedData = aesCipher.doFinal(encryptedData);
    }


    private static SecretKey generateAESKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey key = keyGen.generateKey();
        return key;
    }
}
