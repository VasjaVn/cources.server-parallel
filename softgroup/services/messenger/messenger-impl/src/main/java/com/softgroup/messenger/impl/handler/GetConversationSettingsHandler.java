package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationSettingsRequestData;
import com.softgroup.messenger.api.message.GetConversationSettingsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetConversationSettingsHandler
        extends AbstractRequestHandler<GetConversationSettingsRequestData, GetConversationSettingsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATION_SETTINGS_NAME = "get_conversation_settings";

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATION_SETTINGS_NAME;
    }

    @Override
    public Response<GetConversationSettingsResponseData> commandHandle(Request<GetConversationSettingsRequestData> msg) {
        return null;
    }
}