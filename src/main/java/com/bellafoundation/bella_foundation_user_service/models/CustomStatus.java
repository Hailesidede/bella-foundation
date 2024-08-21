package com.bellafoundation.bella_foundation_user_service.models;

import com.bellafoundation.bella_foundation_user_service.constants.AppConstants;
import com.bellafoundation.bella_foundation_user_service.utils.Util;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomStatus {
    boolean status;
    int code;
    String message;

    @JsonIgnore
    String logCategory;

    @JsonIgnore
    String uniqueIdentity;




    public static CustomStatus map(boolean status, int code,String message){
        CustomStatus customStatus = new CustomStatus();
        customStatus.setStatus(status);
        customStatus.setCode(code);
        customStatus.setMessage(message);
        return customStatus;
    }


    public static CustomStatus map(int code, String message){
        CustomStatus customStatus = new CustomStatus();
        customStatus.setCode(code);
        customStatus.setMessage(message);
        customStatus.setStatus(AppConstants.HttpStatusCode.OK == code);
        return customStatus;
    }

    public static CustomStatus strip(String message){
        CustomStatus customStatus = Util.stripMessage(message);
        customStatus.setStatus(customStatus.getCode() == AppConstants.HttpStatusCode.OK);
        return customStatus;
    }
}
