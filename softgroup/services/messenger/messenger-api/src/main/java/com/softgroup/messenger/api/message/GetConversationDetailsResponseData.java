package com.softgroup.messenger.api.message;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

public class GetConversationDetailsResponseData implements ResponseData {
    private static final long serialVersionUID = -5572869831694738612L;

    private String id;

    private List<ProfileEntity> members;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ProfileEntity> getMembers() {
        return members;
    }

    public void setMembers(List<ProfileEntity> members) {
        this.members = members;
    }
}
