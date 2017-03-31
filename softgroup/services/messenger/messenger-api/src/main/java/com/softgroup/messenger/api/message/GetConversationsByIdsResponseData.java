package com.softgroup.messenger.api.message;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.protocol.ResponseData;

import java.util.List;

public class  GetConversationsByIdsResponseData implements ResponseData {
    private static final long serialVersionUID = -1942571034242358156L;

    private List<ConversationEntity> conversations;

    public List<ConversationEntity> getConversations() {
        return conversations;
    }

    public void setConversations(List<ConversationEntity> conversations) {
        this.conversations = conversations;
    }
}
