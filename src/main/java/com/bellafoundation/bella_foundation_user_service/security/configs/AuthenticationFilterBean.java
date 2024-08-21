package com.bellafoundation.bella_foundation_user_service.security.configs;

import com.bellafoundation.bella_foundation_user_service.security.service.AuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthenticationFilterBean {
    private static final String AUTH_HEADER_STRING ="Authorization";
    private static final String SIGNATURE_HEADER_STRING = "signature";
    private static final String IP_ADDRESS_HEADER_STRING = "IP-Address";
    private static final String CLIENT_ID_HEADER_STRING = "Client-ID";

    private final AuthenticationService authenticationService;
    private final JwtHelper jwtHelper;

    public AuthenticationFilterBean(AuthenticationService authenticationService, JwtHelper jwtHelper) {
        this.authenticationService = authenticationService;
        this.jwtHelper = jwtHelper;
    }
}
