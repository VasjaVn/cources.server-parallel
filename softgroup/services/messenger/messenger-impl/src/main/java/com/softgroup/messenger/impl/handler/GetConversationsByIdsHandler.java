package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsByIdsRequestData;
import com.softgroup.messenger.api.message.GetConversationsByIdsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetConversationsByIdsHandler
        extends AbstractRequestHandler<GetConversationsByIdsRequestData, GetConversationsByIdsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATIONS_BY_IDS_NAME = "get_conversations_by_ids";

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATIONS_BY_IDS_NAME;
    }

    @Override
    public Response<GetConversationsByIdsResponseData> commandHandle(Request<GetConversationsByIdsRequestData> msg) {
        return null;
    }
}