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



    class SystemCode {
        public static final Integer REQUEST_TIMEOUT = 408;
        public static final Integer GATEWAY_TIMEOUT = 504;
        public static final Integer BAD_REQUEST = 400;
        public static final Integer UNAUTHORIZED = 401;
        public static final Integer FORBIDDEN_ACCESS = 403;
        public static final Integer CONFLICT = 409;
        public static final Integer OK = 200;
        public static final Integer NO_CONTENT = 204;
        public static final Integer RESOURCE_NOT_FOUND = 404;
        public static final Integer UNKNOWN_ERROR = 900;
        public static final Integer NULL_POINTER_EXCEPTION = 700;
        public static final Integer NUMBER_FORMAT_EXCEPTION = 701;
        public static final Integer ILLEGAL_ARGUMENT_EXCEPTION = 702;
        public static final Integer RUNTIME_EXCEPTION = 703;
        public static final Integer ILLEGAL_STATE_EXCEPTION = 704;
        public static final Integer NO_SUCH_METHOD_EXCEPTION = 705;
        public static final Integer CLASS_CAST_EXCEPTION = 706;
        public static final Integer EXCEPTION = 707;
        public static final Integer PARSE_EXCEPTION = 708;
        public static final Integer INVOCATION_TARGET_EXCEPTION = 709;
        public static final Integer BAD_KAFKA_RESPONSE = 800;
    }

}
