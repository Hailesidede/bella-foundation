package com.bellafoundation.bella_foundation_user_service.utils;

import com.bellafoundation.bella_foundation_user_service.models.CustomStatus;
import com.bellafoundation.bella_foundation_user_service.security.configs.JwtHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Util <T extends Object>{

    private static final Logger log = LoggerFactory.getLogger(Util.class);

    public static CustomStatus stripMessage(String message){
        String [] codeMessage = message.split(":",2);
        String code = codeMessage[0];
        String msg = codeMessage[1];
        CustomStatus customStatus = new CustomStatus();
        customStatus.setCode(Integer.parseInt(code));
        customStatus.setMessage(msg);
        return customStatus;
    }


    public static String getIp(HttpServletRequest httpServletRequest){
        String xHeader = httpServletRequest.getHeader("X-Forwarded-For");
        if(xHeader == null){
            return httpServletRequest.getRemoteAddr();
        }
        return xHeader.split(",")[0];
    }


    public static String decryptData(String encryptedData){
        return AesGCM.decrypt(JwtHelper.SECRETE_KEY,encryptedData);
    }


    public T fromJson(String json, Class<T> type){
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(json,type);
        }catch (IOException e){
            log.info(e.getMessage());
        }
        return null;
    }
}
