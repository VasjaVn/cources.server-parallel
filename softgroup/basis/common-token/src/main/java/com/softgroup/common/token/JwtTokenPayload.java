package com.softgroup.common.token;

public class JwtTokenPayload {

    private String tokenType;
    private String deviceId;
    private String userId;
    private long createdTime;
    private long expiredTime;

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public long getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(long expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String tokenType;
        private String deviceId;
        private String userId;
        private long createdTime;
        private long expiredTime;

        public Builder withTokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public Builder withDeviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withCreatedTime(long createdTime) {
            this.createdTime = createdTime;
            return this;
        }

        public Builder withExpiredTime(long expiredTime) {
            this.expiredTime = expiredTime;
            return this;
        }

        public JwtTokenPayload build() {
            JwtTokenPayload jwtTokenPayload = new JwtTokenPayload();
            jwtTokenPayload.setTokenType(tokenType);
            jwtTokenPayload.setDeviceId(deviceId);
            jwtTokenPayload.setUserId(userId);
            jwtTokenPayload.setCreatedTime(createdTime);
            jwtTokenPayload.setExpiredTime(expiredTime);
            return jwtTokenPayload;
        }
    }
}