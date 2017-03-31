package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

public class DeleteConversationRequestData implements RequestData {
    private static final long serialVersionUID = 5266404053642532644L;

    private String conversationId;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
}