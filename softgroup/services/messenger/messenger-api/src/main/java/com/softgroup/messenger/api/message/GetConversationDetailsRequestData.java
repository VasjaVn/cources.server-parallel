package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

public class GetConversationDetailsRequestData implements RequestData {
    private static final long serialVersionUID = 7926468786638990999L;

    private String conversationId;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
}
