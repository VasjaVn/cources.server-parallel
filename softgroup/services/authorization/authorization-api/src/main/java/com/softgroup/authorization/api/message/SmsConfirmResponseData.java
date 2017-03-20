package com.softgroup.authorization.api.message;

import com.softgroup.common.protocol.ResponseData;

public class SmsConfirmResponseData implements ResponseData {

    private String deviceToken;

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
