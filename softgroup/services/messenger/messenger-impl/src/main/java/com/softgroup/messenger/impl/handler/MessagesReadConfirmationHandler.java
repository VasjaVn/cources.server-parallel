package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.MessagesReadConfirmationRequestData;
import com.softgroup.messenger.api.message.MessagesReadConfirmationResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class MessagesReadConfirmationHandler
        extends AbstractRequestHandler<MessagesReadConfirmationRequestData, MessagesReadConfirmationResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_MESSEGES_READ_CONFIRMATION_NAME = "messeges_read_confirmation";

    @Override
    public String getName() {
        return MSNG_CMD_MESSEGES_READ_CONFIRMATION_NAME;
    }

    @Override
    public Response<MessagesReadConfirmationResponseData> commandHandle(Request<MessagesReadConfirmationRequestData> msg) {
        return null;
    }
}