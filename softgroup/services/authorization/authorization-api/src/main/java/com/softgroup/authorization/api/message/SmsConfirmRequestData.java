package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.RequestData;

public class SmsConfirmRequestData implements RequestData {

    private String authCode;

    private String registrationRequestUUID;

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getRegistrationRequestUUID() {
        return registrationRequestUUID;
    }

    public void setRegistrationRequestUUID(String registrationRequestUUID) {
        this.registrationRequestUUID = registrationRequestUUID;
    }
}
