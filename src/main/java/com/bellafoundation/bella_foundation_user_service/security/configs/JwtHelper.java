package com.bellafoundation.bella_foundation_user_service.security.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtHelper {
    public static final String TOKEN_PREFIX="BEARER ";
    private static String FILE_PATH;
    private static String PUBLIC_KEY_FILE_NAME;
    public static String SECRETE_KEY;

    public void setAppName(String filePath){
        this.FILE_PATH = filePath;
    }

    public void setPublicKeyFileName(String publicKeyFileName){
        this.PUBLIC_KEY_FILE_NAME = publicKeyFileName;
    }

    public void setSecreteKey(String secreteKey){
        this.SECRETE_KEY = secreteKey;
    }


    public  Object extractAllClaims(String token){
        Claims claims = null;

        try{
            claims = Jwts
                    .parserBuilder()
                    .setSigningKey(AuthHelper.getPublicKeyFromFile(FILE_PATH+PUBLIC_KEY_FILE_NAME))
                    .build()
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,""))
                    .getBody();

            return claims;
        }catch{

        }
    }

}
