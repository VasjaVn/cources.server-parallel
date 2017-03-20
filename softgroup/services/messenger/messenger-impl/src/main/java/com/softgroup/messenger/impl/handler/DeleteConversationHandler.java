package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.DeleteConversationRequestData;
import com.softgroup.messenger.api.message.DeleteConversationResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class DeleteConversationHandler
        extends AbstractRequestHandler<DeleteConversationRequestData, DeleteConversationResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_DELETE_CONVERSATION_NAME = "delete_conversation";

    @Override
    public String getName() {
        return MSNG_CMD_DELETE_CONVERSATION_NAME;
    }

    @Override
    public Response<DeleteConversationResponseData> commandHandle(Request<DeleteConversationRequestData> msg) {
        return null;
    }
}