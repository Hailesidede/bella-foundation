package com.bellafoundation.bella_foundation_user_service.constants;

public interface ResponseMessage {
    // Security and Kafka Specific Response Keys
    String SUCCESS = "success";
    String FIELD_REQUIRED = "field.required";
    String UNEXPECTED_ERROR = "unexpected.error";
    String MISSING_FIELDS = "missing.fields";
    String RECORDS_FOUND = "records.found";
    String NO_RECORDS_FOUND = "no.records.found";
    String NULL_POINTER_ERROR = "null.pointer.exception";
    String UNKNOWN_REQUEST_TYPE = "unknown.request.type";
    String INVALID_SIGNATURE = "invalid.signature";
    String INVALID_CLIENT_ID = "invalid.client.id";
    String INVALID_PUBLIC_KEY = "invalid.public.key";
    String SIGNATURE_REQUIRED = "signature.required";
    String PLAIN_TEXT_REQUIRED = "plain-text.required";
    String NO_KEYS_CONFIGURED = "no.keys.configured";
    String INVALID_API_KEY = "invalid.api-key";
    String MERCHANT_CODE_NOT_FOUND = "merchant.code.not.found";
    String MERCHANT_PUBLIC_KEY_NOT_FOUND = "merchant.public-key.not.found";
    String MERCHANT_NOT_FOUND = "merchant.not.found";
    String INVALID_MERCHANT_HASH = "invalid.public-key";
    String NO_SIGNATURE_CONFIGURED = "no.signature.configured";
    String TOKEN_REQUIRED = "token.required";
    String TOKEN_EXPIRED = "token.expired";
    String INVALID_TOKEN = "invalid.token";
    String PERMISSIONS_REQUIRED = "permission.required";

    // Notification Service Keys Response
    String SEND_MAIL_FAILURE = "send.mail.failure";
    String SEND_SMS_FAILURE = "send.sms.failure";
    String INVALID_NOTIFICATION_TYPE = "invalid.notification.type";
    String INVALID_WHATSAPP_TEMPLATE_CATEGORY = "invalid.whatsapp.template.category";
    String EMAIL_NOT_FOUND = "email.not.found";
    String EMAIL_TEMPLATE_NOT_FOUND = "email.template.not.found";
    String EMAIL_TEMPLATE_EXISTS = "email.template.exists";
    String UNKNOWN_TEMPLATE_KEY = "unknown.template.key";
    String KEY_REQUIRED = "key.required";
    String TEMPLATE_FIELD_NOT_FOUND = "template.field.not.found";
    String TEMPLATE_FIELD_EXISTS = "template.field.exists";
    String SMS_TEMPLATE_EXISTS = "sms.template.exists";
    String SMS_TEMPLATE_NOT_FOUND = "sms.template.not.found";
    String SMS_NOT_FOUND = "sms.not.found";
    String SMS_TEMPLATE_DELETED = "sms.templated.deleted";
    String EMAIL_TEMPLATE_DELETED = "email.templated.deleted";
    String PUSH_TEMPLATE_DELETED = "push.templated.deleted";
    String TEMPLATE_ACTIVATED = "template.activated";
    String TEMPLATE_DEACTIVATED = "template.deactivated";
    String INVALID_DATA = "invalid.data";
    String QUICK_ALERT_NOT_FOUND = "quick.alert.not.found";
    String WHATSAPP_TEMPLATE_NOT_FOUND="whatsapp.template.not.found";
    String WHATSAPP_TEMPLATE_ALREADY_EXISTS="whatsapp.template.already.exists";
    String WHATSAPP_TEMPLATE_DELETED_SUCCESSFULLY= " whatsapp.templates.deleted.successfully";

}
