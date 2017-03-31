package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.dao.api.service.ConversationDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.exceptions.MapperException;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.messenger.api.message.UpdateConversationSettingsRequestData;
import com.softgroup.messenger.api.message.UpdateConversationSettingsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UpdateConversationSettingsHandler
        extends AbstractRequestHandler<UpdateConversationSettingsRequestData, UpdateConversationSettingsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_UPDATE_CONVERSATION_SETTINGS_NAME = "update_conversation_settings";

    @Autowired
    private ConversationDaoService conversationDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_UPDATE_CONVERSATION_SETTINGS_NAME;
    }

    @Override
    public Response<UpdateConversationSettingsResponseData> commandHandle(Request<UpdateConversationSettingsRequestData> request) {
        UpdateConversationSettingsResponseData responseData = null;
        ResponseStatus responseStatus = ResponseStatus.BAD_REQUEST;

        try {
            UpdateConversationSettingsRequestData requestData =
                    new JacksonDataMapper().convert((Map<String, Object>) request.getData(), UpdateConversationSettingsRequestData.class );

            String id = requestData.getId();

            ConversationEntity conversation = conversationDaoService.findById( id );
            if ( conversation != null ) {
                conversation.setName( requestData.getName() );
                conversation.setAdminId( requestData.getAdminId() );
                conversation.setLogoImageUri( requestData.getLogoImageUri() );

                conversationDaoService.save( conversation );

                responseData = new UpdateConversationSettingsResponseData();
                responseData.setId( requestData.getId() );
                responseData.setName( requestData.getName() );
                responseData.setAdminId( requestData.getAdminId() );
                responseData.setLogoImageUri( requestData.getLogoImageUri() );

                responseStatus = ResponseStatus.OK;
            }

        } catch (MapperException e) {
        }

        return ResponseFactory.create( request, responseData, responseStatus );
    }
}