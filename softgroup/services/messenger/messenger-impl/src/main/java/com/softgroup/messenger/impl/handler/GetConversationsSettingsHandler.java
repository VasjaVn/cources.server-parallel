package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.dao.api.service.ConversationDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.messenger.api.dto.ConversationSettings;
import com.softgroup.messenger.api.message.GetConversationsSettingsRequestData;
import com.softgroup.messenger.api.message.GetConversationsSettingsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GetConversationsSettingsHandler
        extends AbstractRequestHandler<GetConversationsSettingsRequestData, GetConversationsSettingsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATIONS_SETTINGS_NAME = "get_conversations_settings";

    @Autowired
    private ConversationDaoService conversationDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATIONS_SETTINGS_NAME;
    }

    @Override
    public Response<GetConversationsSettingsResponseData> commandHandle(Request<GetConversationsSettingsRequestData> request) {
        GetConversationsSettingsResponseData responseData = null;
        ResponseStatus responseStatus = ResponseStatus.BAD_REQUEST;

        GetConversationsSettingsRequestData requestData =
                new JacksonDataMapper().convert((Map<String, Object>) request.getData(), GetConversationsSettingsRequestData.class );

        List<String> conversationsIds = requestData.getConversationsIds();

        if ( conversationsIds != null ) {
            List<ConversationSettings> conversationsSettings = new ArrayList<>();

            for ( String conversationId : conversationsIds ) {
                ConversationEntity conversation = conversationDaoService.findById( conversationId );

                if ( conversation != null ) {
                    ConversationSettings conversationSettings = new ConversationSettings();
                    conversationSettings.setId( conversationId );
                    conversationSettings.setName( conversation.getName() );
                    conversationSettings.setAdminId( conversation.getAdminId() );
                    conversationSettings.setLogoImageUri( conversation.getLogoImageUri() );

                    conversationsSettings.add( conversationSettings );
                }
            }

            responseData = new GetConversationsSettingsResponseData();
            responseData.setConversationsSettings( conversationsSettings );
        }

        return ResponseFactory.create( request, responseData, responseStatus);
    }
}