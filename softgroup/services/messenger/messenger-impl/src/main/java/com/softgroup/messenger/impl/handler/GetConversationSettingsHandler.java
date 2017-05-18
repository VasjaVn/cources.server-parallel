package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.dao.api.service.ConversationDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.messenger.api.dto.ConversationSettingsDto;
import com.softgroup.messenger.api.message.GetConversationSettingsRequestData;
import com.softgroup.messenger.api.message.GetConversationSettingsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GetConversationSettingsHandler
        extends AbstractRequestHandler<GetConversationSettingsRequestData, GetConversationSettingsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATION_SETTINGS_NAME = "get_conversation_settings";

    @Autowired
    private ConversationDaoService conversationDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATION_SETTINGS_NAME;
    }

    @Override
    public Response<GetConversationSettingsResponseData> commandHandle(Request<GetConversationSettingsRequestData> request) {
        GetConversationSettingsResponseData responseData = null;
        ResponseStatus responseStatus = ResponseStatus.BAD_REQUEST;

        GetConversationSettingsRequestData requestData =
                new JacksonDataMapper().convert((Map<String, Object>) request.getData(), GetConversationSettingsRequestData.class);

        String conversationId = requestData.getConversationId();

        ConversationEntity conversation = conversationDaoService.findById( conversationId );

        ConversationSettingsDto conversationSettingsDto = null;
        if ( conversation != null ) {
            conversationSettingsDto = new ConversationSettingsDto();

            conversationSettingsDto.setId( conversationId );
            conversationSettingsDto.setName( conversation.getName() );
            conversationSettingsDto.setAdminId( conversation.getAdminId() );
            conversationSettingsDto.setLogoImageUri( conversation.getLogoImageUri() );

            responseData = new GetConversationSettingsResponseData();
            responseData.setConversationSettingsDto(conversationSettingsDto);

            responseStatus = ResponseStatus.OK;
        }

        return ResponseFactory.create( request, responseData, responseStatus);
    }
}