package com.softgroup.profile.api.message;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.protocol.ResponseData;

public class GetMyProfileResponseData implements ResponseData {
    private static final long serialVersionUID = 3066867066075855991L;

    private ProfileEntity profile;

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }
}
