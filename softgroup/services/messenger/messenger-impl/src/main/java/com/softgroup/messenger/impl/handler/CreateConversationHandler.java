package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.messenger.ConversationDetailsEntity;
import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.dao.api.service.ConversationDaoService;
import com.softgroup.common.dao.api.service.ConversationDetailsDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.messenger.api.message.CreateConversationRequestData;
import com.softgroup.messenger.api.message.CreateConversationResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class CreateConversationHandler
        extends AbstractRequestHandler<CreateConversationRequestData, CreateConversationResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_CREATE_CONVERSATION_NAME = "create_conversation";

    @Autowired
    private ConversationDaoService conversationDaoService;

    @Autowired
    private ConversationDetailsDaoService conversationDetailsDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_CREATE_CONVERSATION_NAME;
    }

    @Override
    public Response<CreateConversationResponseData> commandHandle(Request<CreateConversationRequestData> request) {
        CreateConversationRequestData requestData =
                new JacksonDataMapper().convert((Map<String, Object>) request.getData(), CreateConversationRequestData.class );

        String conversationId = UUID.randomUUID().toString();

        ConversationEntity conversationEntity = new ConversationEntity();
        conversationEntity.setId( conversationId );
        conversationEntity.setName( "" );
        conversationEntity.setType( requestData.getType() );
        conversationEntity.setLastMessageIndex( 0L );
        conversationEntity.setAdminId( request.getCredential().getUserId() );
        conversationEntity.setLogoImageUri( "" );
        conversationEntity.setExists( true );

        conversationDaoService.save( conversationEntity );

        for (String memberId : requestData.getMembersIds()) {
            ConversationDetailsEntity entity = new ConversationDetailsEntity();
            entity.setId( UUID.randomUUID().toString() );
            entity.setConversationId( conversationId );
            entity.setMemberId( memberId );
            conversationDetailsDaoService.save( entity );
        }

        CreateConversationResponseData responseData = new CreateConversationResponseData();
        responseData.setConversation(conversationEntity);

        return ResponseFactory.create(request, responseData, ResponseStatus.OK );
    }
}