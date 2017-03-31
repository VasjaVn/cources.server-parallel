package com.softgroup.common.protocol;

public class Credential {

    private final String deviceId;
    private final String userId;

    public Credential(String deviceId, String userId) {
        this.deviceId = deviceId;
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getUserId() {
        return userId;
    }
}
