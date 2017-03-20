package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.CreateConversationRequestData;
import com.softgroup.messenger.api.message.CreateConversationResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateConversationHandler
        extends AbstractRequestHandler<CreateConversationRequestData, CreateConversationResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_CREATE_CONVERSATION_NAME = "create_conversation";

    @Override
    public String getName() {
        return MSNG_CMD_CREATE_CONVERSATION_NAME;
    }

    @Override
    public Response<CreateConversationResponseData> commandHandle(Request<CreateConversationRequestData> msg) {
        return null;
    }
}