package com.softgroup.messenger.api.message;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.protocol.ResponseData;

public class CreateConversationResponseData implements ResponseData {
    private static final long serialVersionUID = -3421861142295996621L;

    private ConversationEntity conversation;

    public ConversationEntity getConversation() {
        return conversation;
    }

    public void setConversation(ConversationEntity conversation) {
        this.conversation = conversation;
    }
}