package com.bellafoundation.bella_foundation_user_service.security.configs;

import com.bellafoundation.bella_foundation_user_service.security.entities.Permission;
import com.bellafoundation.bella_foundation_user_service.security.models.CredentialModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApiPrincipal implements UserDetails{
    private final CredentialModel account;
    private final String password;

    private String signature;
    private String requestURI;
    private String userType;
    private final String httpMethod;
    private final String requestBody;
    private final String queryString;
    private final String ipAddress;

    public ApiPrincipal(CredentialModel account, String password, String httpMethod, String requestBody, String queryString, String ipAddress) {
        this.account = account;
        this.password = password;
        this.httpMethod = httpMethod;
        this.requestBody = requestBody;
        this.queryString = queryString;
        this.ipAddress = ipAddress;
    }

    public CredentialModel getAccount() {
        return account;
    }

    public String getSignature() {
        return signature;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public String getUserType() {
        return userType;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Permission permission: account.getPermissions()) {
            authorities.add(new SimpleGrantedAuthority(permission.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return account != null ? account.getUserName() :null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
