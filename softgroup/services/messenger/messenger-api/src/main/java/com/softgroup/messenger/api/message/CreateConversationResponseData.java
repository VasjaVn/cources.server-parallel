package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationDto;

public class CreateConversationResponseData implements ResponseData {
    private static final long serialVersionUID = -3421861142295996621L;

    private ConversationDto conversation;

    public ConversationDto getConversation() {
        return conversation;
    }

    public void setConversationDto(ConversationDto conversation) {
        this.conversation = conversation;
    }
}