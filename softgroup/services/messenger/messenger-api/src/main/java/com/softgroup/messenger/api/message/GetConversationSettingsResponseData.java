package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationSettingsDto;

public class GetConversationSettingsResponseData implements ResponseData {
    private static final long serialVersionUID = -823982739540964715L;

    private ConversationSettingsDto conversationSettingsDto;

    public ConversationSettingsDto getConversationSettingsDto() {
        return conversationSettingsDto;
    }

    public void setConversationSettingsDto(ConversationSettingsDto conversationSettingsDto) {
        this.conversationSettingsDto = conversationSettingsDto;
    }
}