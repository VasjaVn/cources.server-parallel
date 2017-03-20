package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsDetailsRequestData;
import com.softgroup.messenger.api.message.GetConversationsDetailsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetConversationsDetailsHandler
        extends AbstractRequestHandler<GetConversationsDetailsRequestData, GetConversationsDetailsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATIONS_DETAILS_NAME = "get_conversations_details";

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATIONS_DETAILS_NAME;
    }

    @Override
    public Response<GetConversationsDetailsResponseData> commandHandle(Request<GetConversationsDetailsRequestData> msg) {
        return null;
    }
}