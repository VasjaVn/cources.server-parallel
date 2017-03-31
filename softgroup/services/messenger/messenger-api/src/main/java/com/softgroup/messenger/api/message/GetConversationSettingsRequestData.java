package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

public class GetConversationSettingsRequestData implements RequestData {
    private static final long serialVersionUID = -6608736567723112101L;

    private String conversationId;

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }
}
