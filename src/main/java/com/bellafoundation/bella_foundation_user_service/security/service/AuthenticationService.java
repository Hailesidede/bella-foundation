package com.bellafoundation.bella_foundation_user_service.security.service;

import com.bellafoundation.bella_foundation_user_service.constants.AppConstants;
import com.bellafoundation.bella_foundation_user_service.models.CustomResponse;
import com.bellafoundation.bella_foundation_user_service.models.CustomStatus;
import com.bellafoundation.bella_foundation_user_service.security.entities.ApiSignatures;
import com.bellafoundation.bella_foundation_user_service.security.entities.UserPermission;
import com.bellafoundation.bella_foundation_user_service.security.repo.ApiSignatureRepository;
import com.bellafoundation.bella_foundation_user_service.security.repo.AppCredentialRepository;
import com.bellafoundation.bella_foundation_user_service.security.repo.PermissionRepository;
import com.bellafoundation.bella_foundation_user_service.security.repo.UserPermissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class AuthenticationService {
    private final UserPermissionRepository userPermissionRepository;
    private final PermissionRepository permissionRepository;
    private final ApiSignatureRepository apiSignatureRepository;
    private final AppCredentialRepository appCredentialRepository;

    public AuthenticationService(UserPermissionRepository userPermissionRepository, PermissionRepository permissionRepository, ApiSignatureRepository apiSignatureRepository, AppCredentialRepository appCredentialRepository) {
        this.userPermissionRepository = userPermissionRepository;
        this.permissionRepository = permissionRepository;
        this.apiSignatureRepository = apiSignatureRepository;
        this.appCredentialRepository = appCredentialRepository;
    }

    @Value("${signature.public.key}")
    private String signaturePublicKey;

    @Value("${file.path}")
    private String filePath;


    public static Map<String, String> getQueryMap(String query){
        String [] params= query.split("&");
        Map<String, String> map = new HashMap<>();

        for(String param : params){
            String name= param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);

        }
        return map;
    }


    public boolean checkAuth(String url, Long userId){
        boolean isAuth= false;

        UserPermission userPermission= userPermissionRepository.findFirstByPermission_UrlAndUser_IdAndStatus_Code(url,userId, AppConstants.Status.ACTIVE);
        if(userPermission !=null){
            isAuth= true;
        }
        log.info("isAuth :{}",isAuth);
        return isAuth;

    }


    public boolean checkUrlPermission(String url){
        boolean isSet = false;
        if(permissionRepository.existsByUrlAndStatus_Code(url,AppConstants.Status.ACTIVE)){
            isSet= true;
        }
        log.info("permission set for url is :{}",isSet);
        return isSet;
    }


    public CustomResponse<String> getFormulaeKeys(String url, String requestMethod, String jsonBody, String queryString){
        log.info("URL :{}",url+"requestBody :{}",jsonBody);

        ApiSignatures apiSignatures = apiSignatureRepository.findFirstByUrlAndStatus_Code(url,AppConstants.Status.ACTIVE);
        CustomStatus status;
        List<String> keys = new ArrayList<>();
        String finalStr = null;

        if(apiSignatures != null){
            keys= Arrays.asList(apiSignatures.getSignFormulae().split("\\+"));
            if(!keys.isEmpty()){
                if (requestMethod.equals("POST") || requestMethod.equalsIgnoreCase("PUT")){
                    finalStr= getPlainTextFromQueryString(keys,queryString);
                }

            }

            status = CustomStatus.strip(Translator.Lo)

        }
    }



    public String getPlainTextFromQueryString(List<String> keys, String queryString){
        StringBuilder stringBuilder = new StringBuilder();

        for(String key : keys){
            stringBuilder.append(getQueryMap(queryString).get(key));
        }
        return stringBuilder.toString();
    }


}
