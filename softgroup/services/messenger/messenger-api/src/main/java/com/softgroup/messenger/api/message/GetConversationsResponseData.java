package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;
import com.softgroup.messenger.api.dto.ConversationDto;

import java.util.List;

public class GetConversationsResponseData implements ResponseData {
    private static final long serialVersionUID = -1334799498586881415L;

    private List<ConversationDto> conversations;

    public List<ConversationDto> getConversations() {
        return conversations;
    }

    public void setConversations(List<ConversationDto> conversations) {
        this.conversations = conversations;
    }
}
