package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

public class UpdateConversationSettingsResponseData implements ResponseData {
    private static final long serialVersionUID = 984719511438813462L;

    private String id;
    private String adminId;
    private String name;
    private String logoImageUri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoImageUri() {
        return logoImageUri;
    }

    public void setLogoImageUri(String logoImageUri) {
        this.logoImageUri = logoImageUri;
    }
}