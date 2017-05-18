package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationSettingsDto;

import java.util.List;

public class GetConversationsSettingsResponseData implements ResponseData {
    private static final long serialVersionUID = -3194531740517594961L;

    private List<ConversationSettingsDto> conversationsSettings;

    public List<ConversationSettingsDto> getConversationsSettings() {
        return conversationsSettings;
    }

    public void setConversationsSettings(List<ConversationSettingsDto> conversationsSettings) {
        this.conversationsSettings = conversationsSettings;
    }
}