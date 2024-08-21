package com.bellafoundation.bella_foundation_user_service.utils;

import com.bellafoundation.bella_foundation_user_service.models.CustomStatus;

public class Util <T extends Object>{

    public static CustomStatus stripMessage(String message){
        String [] codeMessage = message.split(":",2);
        String code = codeMessage[0];
        String msg = codeMessage[1];
        CustomStatus customStatus = new CustomStatus();
        customStatus.setCode(Integer.parseInt(code));
        customStatus.setMessage(msg);
        return customStatus;
    }
}
