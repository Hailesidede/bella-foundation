package com.bellafoundation.bella_foundation_user_service.constants;

import org.springframework.http.HttpStatus;

public interface AppConstants {

    class Status{
        public static final String PENDING ="PEND";
        public static final String ACTIVE = "ACTV";
        public static final String SENT = "SENT";
        public static final String FAILED = "FAIL";
        public static final String DELETED = "DEL";
        public static final String INACTIVE ="IACTV";
        public static final String PARTIALLY_PAID = "P_PAID";
        public static final String PAID = "PAID";
        public static final String SUCCESS = "SUCCESS";
    }


    class HttpStatusCode {
        public static final Integer OK = HttpStatus.OK.value();
        public static final Integer UNAUTHORIZED = HttpStatus.UNAUTHORIZED.value();
        public static final Integer BAD_REQUEST = HttpStatus.BAD_REQUEST.value();
        public static final Integer FORBIDDEN_ACCESS= HttpStatus.FORBIDDEN.value();
        public static final Integer NOT_FOUND = HttpStatus.NOT_FOUND.value();
        public static final Integer SERVER_ERROR = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

}
