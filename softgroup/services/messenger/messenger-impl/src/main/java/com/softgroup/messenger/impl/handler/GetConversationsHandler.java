package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsRequestData;
import com.softgroup.messenger.api.message.GetConversationsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetConversationsHandler
        extends AbstractRequestHandler<GetConversationsRequestData, GetConversationsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATIONS_NAME = "get_conversations";

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATIONS_NAME;
    }

    @Override
    public Response<GetConversationsResponseData> commandHandle(Request<GetConversationsRequestData> msg) {
        return null;
    }
}