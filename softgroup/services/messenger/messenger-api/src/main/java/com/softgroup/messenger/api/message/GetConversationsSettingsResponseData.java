package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationSettings;

import java.util.List;

public class GetConversationsSettingsResponseData implements ResponseData {
    private static final long serialVersionUID = -3194531740517594961L;

    private List<ConversationSettings> conversationsSettings;

    public List<ConversationSettings> getConversationsSettings() {
        return conversationsSettings;
    }

    public void setConversationsSettings(List<ConversationSettings> conversationsSettings) {
        this.conversationsSettings = conversationsSettings;
    }
}