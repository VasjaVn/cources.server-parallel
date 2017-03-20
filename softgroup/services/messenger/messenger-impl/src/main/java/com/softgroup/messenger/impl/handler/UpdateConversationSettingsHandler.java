package com.softgroup.messenger.impl.handler;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.messenger.api.message.UpdateConversationSettingsRequestData;
import com.softgroup.messenger.api.message.UpdateConversationSettingsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.stereotype.Component;

@Component
public class UpdateConversationSettingsHandler
        extends AbstractRequestHandler<UpdateConversationSettingsRequestData, UpdateConversationSettingsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_UPDATE_CONVERSATION_SETTINGS_NAME = "update_conversation_settings";

    @Override
    public String getName() {
        return MSNG_CMD_UPDATE_CONVERSATION_SETTINGS_NAME;
    }

    @Override
    public Response<UpdateConversationSettingsResponseData> commandHandle(Request<UpdateConversationSettingsRequestData> msg) {
        return null;
    }
}