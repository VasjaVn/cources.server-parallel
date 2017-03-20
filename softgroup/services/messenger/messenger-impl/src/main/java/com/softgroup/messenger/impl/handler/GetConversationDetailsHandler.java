package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationDetailsRequestData;
import com.softgroup.messenger.api.message.GetConversationDetailsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetConversationDetailsHandler
        extends AbstractRequestHandler<GetConversationDetailsRequestData, GetConversationDetailsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATION_DETAILS_NAME = "get_conversation_details";

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATION_DETAILS_NAME;
    }

    @Override
    public Response<GetConversationDetailsResponseData> commandHandle(Request<GetConversationDetailsRequestData> msg) {
        return null;
    }
}