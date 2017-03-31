package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

public class GetConversationsByIdsRequestData implements RequestData {
    private static final long serialVersionUID = 3411739307747434481L;

    private List<String> conversationsIds;

    public List<String> getConversationsIds() {
        return conversationsIds;
    }

    public void setConversationsIds(List<String> conversationsIds) {
        this.conversationsIds = conversationsIds;
    }
}
