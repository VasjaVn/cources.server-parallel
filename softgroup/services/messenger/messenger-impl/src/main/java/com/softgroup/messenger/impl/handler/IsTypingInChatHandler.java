package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.IsTypingInChatRequestData;
import com.softgroup.messenger.api.message.IsTypingInChatResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class IsTypingInChatHandler
        extends AbstractRequestHandler<IsTypingInChatRequestData, IsTypingInChatResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_IS_TYPING_IN_CHAT_NAME = "is_typing_in_chat";

    @Override
    public String getName() {
        return MSNG_CMD_IS_TYPING_IN_CHAT_NAME;
    }

    @Override
    public Response<IsTypingInChatResponseData> commandHandle(Request<IsTypingInChatRequestData> msg) {
        return null;
    }
}