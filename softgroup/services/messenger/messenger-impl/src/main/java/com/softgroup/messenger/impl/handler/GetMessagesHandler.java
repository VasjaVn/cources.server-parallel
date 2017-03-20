package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetMessagesRequestData;
import com.softgroup.messenger.api.message.GetMessagesResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetMessagesHandler
        extends AbstractRequestHandler<GetMessagesRequestData, GetMessagesResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_MESSEGES_NAME = "get_messeges";

    @Override
    public String getName() {
        return MSNG_CMD_GET_MESSEGES_NAME;
    }

    @Override
    public Response<GetMessagesResponseData> commandHandle(Request<GetMessagesRequestData> msg) {
        return null;
    }
}