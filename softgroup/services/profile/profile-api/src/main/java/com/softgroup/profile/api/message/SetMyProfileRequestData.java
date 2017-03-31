package com.softgroup.profile.api.message;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.protocol.RequestData;

public class SetMyProfileRequestData implements RequestData {
    private static final long serialVersionUID = -4350903446096361734L;

    private ProfileEntity profile;

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }
}
