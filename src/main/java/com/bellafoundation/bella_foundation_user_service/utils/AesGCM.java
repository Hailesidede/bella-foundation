package com.bellafoundation.bella_foundation_user_service.utils;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Slf4j
public class AesGCM {
    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final String FACTORY_INSTANCE ="PBKDF2WithHmacSHA1";
    private static final int TAG_LENGTH_BIT = 128;
    private static final int IV_LENGTH_BYTE = 12;
    private static final int SALT_LENGTH_BYTE = 16;
    private static final String ALGORITHM_TYPE = "AES";
    private static final int KEY_LENGTH = 256;
    private static final int ITERATION_COUNT = 65536;
    private static final Charset UTF_8= StandardCharsets.UTF_8;


    public static byte[] getRandomNonce(int length){
        byte[] nonce = new byte[length];
        new SecureRandom().nextBytes(nonce);
        return nonce;
    }


    public static SecretKey getSecretKey(String password, byte[] salt)
    throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);

        SecretKeyFactory factory =SecretKeyFactory.getInstance(FACTORY_INSTANCE);
        return new SecretKeySpec(factory.generateSecret(spec).getEncoded(),ALGORITHM);
    }


    public static String encrypt(String password, String plainText){
        try{
            byte[] salt = getRandomNonce(SALT_LENGTH_BYTE);
            SecretKey secretKey = getSecretKey(password,salt);


            byte[] iv = getRandomNonce(IV_LENGTH_BYTE);
            Cipher cipher = initCipher(Cipher.ENCRYPT_MODE,secretKey,iv);

            byte[] encryptedMessageByte = cipher.doFinal(plainText.getBytes(UTF_8));

            byte[] cipherByte = ByteBuffer.allocate(iv.length + salt.length+ encryptedMessageByte.length)
                    .put(iv)
                    .put(salt)
                    .put(encryptedMessageByte)
                    .array();
            return Base64.getEncoder().encodeToString(cipherByte);

        }catch (Exception e){
            log.error("error",e);
            return null;

        }
    }


    public static String decrypt(String password, String cipherMessage){
        try{
            byte[] decodedCipherMessage = Base64.getDecoder().decode(cipherMessage);
            ByteBuffer byteBuffer = ByteBuffer.wrap(decodedCipherMessage);

            byte[] iv = new byte[IV_LENGTH_BYTE];
            byteBuffer.get(iv);

            byte[] salt = new byte[SALT_LENGTH_BYTE];
            byteBuffer.get(salt);

            byte[] encyptedByte = new byte[byteBuffer.remaining()];
            byteBuffer.get(encyptedByte);

            SecretKey secretKey = getSecretKey(password,salt);
            Cipher cipher = initCipher(Cipher.DECRYPT_MODE, secretKey,iv);

            byte[] decryptedMessageByte = cipher.doFinal(encyptedByte);
            return new String(decryptedMessageByte,UTF_8);
        }catch (Exception e){
            log.info("error",e);
            return null;
        }
    }


    public static Cipher initCipher(int mode, SecretKey secretKey, byte[] iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(mode,secretKey, new GCMParameterSpec(TAG_LENGTH_BIT,iv));
        return cipher;
    }
}

