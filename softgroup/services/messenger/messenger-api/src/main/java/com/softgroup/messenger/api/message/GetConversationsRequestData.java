package com.softgroup.messenger.api.message;

import com.softgroup.common.protocol.RequestData;

public class GetConversationsRequestData implements RequestData {
    private static final long serialVersionUID = 6548306886135677080L;

    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
