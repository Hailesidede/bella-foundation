package com.bellafoundation.bella_foundation_user_service.security.configs;

import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
public class AuthHelper {


    public static String extractPublicKey(String publicKeyContent){
        String begin = "-----BEGIN PUBLIC KEY-----";
        String end = "-----END PUBLIC KEY-----";
        String spaces ="\\n";
        publicKeyContent = publicKeyContent.replaceAll(spaces,"").replace(begin,"").replace(end,"");
        return publicKeyContent;

    }

    public static RSAPublicKey getPublicKeyFromBase64(String encodedBase64KeyText){
        RSAPublicKey pubKey = null;

        try{
            byte[] publicBytes = Base64.getDecoder().decode(encodedBase64KeyText);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
            KeyFactory keyFactory =KeyFactory.getInstance("RSA");
            pubKey= (RSAPublicKey)keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException  |InvalidKeySpecException e) {
            e.getLocalizedMessage();
        }
        return pubKey;
    }


    public static boolean verifySignature(String plainText, String signature, PublicKey publicKey){
        try {
            Signature publicSignature =Signature.getInstance("SHA256WithRSA");
            publicSignature.initVerify(publicKey);
            publicSignature.update(plainText.getBytes(UTF_8));

            byte[] signatureBytes = Base64.getDecoder().decode(signature);

            return publicSignature.verify(signatureBytes);
        }catch (Exception e){
           log.info( e.getLocalizedMessage());

        }
    }


}
