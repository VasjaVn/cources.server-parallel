package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.GetConversationsSettingsRequestData;
import com.softgroup.messenger.api.message.GetConversationsSettingsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class GetConversationsSettingsHandler
        extends AbstractRequestHandler<GetConversationsSettingsRequestData, GetConversationsSettingsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATIONS_SETTINGS_NAME = "get_conversations_settings";

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATIONS_SETTINGS_NAME;
    }

    @Override
    public Response<GetConversationsSettingsResponseData> commandHandle(Request<GetConversationsSettingsRequestData> msg) {
        return null;
    }
}