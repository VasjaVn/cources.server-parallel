package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.SendMessageRequestData;
import com.softgroup.messenger.api.message.SendMessageResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class SendMessageHandler
        extends AbstractRequestHandler<SendMessageRequestData, SendMessageResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_SEND_MESSEGES_NAME = "send_messege";

    @Override
    public String getName() {
        return MSNG_CMD_SEND_MESSEGES_NAME;
    }

    @Override
    public Response<SendMessageResponseData> commandHandle(Request<SendMessageRequestData> msg) {
        return null;
    }
}