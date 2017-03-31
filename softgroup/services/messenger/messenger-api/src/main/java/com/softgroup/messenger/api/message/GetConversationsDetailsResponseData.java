package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.ResponseData;

import java.util.List;

public class GetConversationsDetailsResponseData implements ResponseData {
    private static final long serialVersionUID = 8475572943494906150L;

    private List<GetConversationDetailsResponseData> conversationsDetails;

    public List<GetConversationDetailsResponseData> getConversationsDetails() {
        return conversationsDetails;
    }

    public void setConversationsDetails(List<GetConversationDetailsResponseData> conversationsDetails) {
        this.conversationsDetails = conversationsDetails;
    }
}
