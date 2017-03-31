package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

public class UpdateConversationSettingsRequestData implements RequestData {
    private static final long serialVersionUID = 6371559117605366925L;

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