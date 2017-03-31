package com.softgroup.authorization.api;

public class RegisterData {

    private String phoneNumber;
    private String deviceId;
    private String localeCode;

    private String registrationRequestUuid;
    private String authCode;
    private long registrationTimeoutSec;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getRegistrationRequestUuid() {
        return registrationRequestUuid;
    }

    public void setRegistrationRequestUuid(String registrationRequestUuid) {
        this.registrationRequestUuid = registrationRequestUuid;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public long getRegistrationTimeoutSec() {
        return registrationTimeoutSec;
    }

    public void setRegistrationTimeoutSec(long registrationTimeoutSec) {
        this.registrationTimeoutSec = registrationTimeoutSec;
    }
}