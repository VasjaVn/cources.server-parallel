package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

import java.util.List;

public class GetConversationsDetailsRequestData implements RequestData {
    private static final long serialVersionUID = -4895386683204250151L;

    private List<String> conversationsIds;

    public List<String> getConversationsIds() {
        return conversationsIds;
    }

    public void setConversationsIds(List<String> conversationsIds) {
        this.conversationsIds = conversationsIds;
    }
}
