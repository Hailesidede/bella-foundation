package com.bellafoundation.bella_foundation_user_service.exceptions;

import com.bellafoundation.bella_foundation_user_service.constants.AppConstants;
import com.bellafoundation.bella_foundation_user_service.constants.ResponseMessage;
import com.bellafoundation.bella_foundation_user_service.models.CustomStatus;
import com.bellafoundation.bella_foundation_user_service.security.configs.ApiPrincipal;
import com.bellafoundation.bella_foundation_user_service.security.configs.JwtHelper;
import com.bellafoundation.bella_foundation_user_service.security.helpers.Translator;
import com.bellafoundation.bella_foundation_user_service.security.models.CredentialModel;
import com.bellafoundation.bella_foundation_user_service.utils.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
@ControllerAdvice
public class BaseException {
    public static final String AUTH_HEADER_STRING = "authorization";

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public static CustomStatus handleBaseExceptions(HttpServletRequest httpServletRequest, Exception exception) throws IOException {
        String errorMessage = exception.getMessage();
        Integer code = AppConstants.SystemCode.EXCEPTION;

        if(errorMessage == null){
            errorMessage = Translator.toLocale(ResponseMessage.NULL_POINTER_ERROR);
            code = AppConstants.SystemCode.NULL_POINTER_EXCEPTION;
        }

        return handleBaseExceptions(httpServletRequest,exception,errorMessage,code);
    }


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public static CustomStatus handleBaseExceptions(HttpServletRequest httpServletRequest, Exception exception,String errorMsg, Integer code) throws IOException {

        ApiPrincipal apiPrincipal = getUserDetails(httpServletRequest);

        MessageDispatcher.logSystemErrorMsg()
    }





    public static ApiPrincipal getUserDetails(HttpServletRequest httpServletRequest) throws IOException {
        String token = httpServletRequest.getHeader(AUTH_HEADER_STRING);
        String requestBody = httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        String urlURI = httpServletRequest.getRequestURI();
        String queryString = httpServletRequest.getQueryString();
        String httpMethod = httpServletRequest.getMethod();
        String ipAddress = Util.getIp(httpServletRequest);

        String authType = null;

        CredentialModel credentialModel = null;
        String environment = null;

        if(token != null){
            Object claimsObject = new JwtHelper().extractAllClaims(token);

            if(claimsObject instanceof Claims claims){
                authType =(String) claims.get("auth_type");
                environment =(String) claims.get("env");

                String decryptedContent =Util.decryptData(claims.get("account").toString());
                credentialModel = new Util<CredentialModel>().fromJson(decryptedContent,CredentialModel.class);
            }
        }
        return new ApiPrincipal(credentialModel,token,authType,null,urlURI,httpMethod,requestBody,queryString,ipAddress);

    }
}
