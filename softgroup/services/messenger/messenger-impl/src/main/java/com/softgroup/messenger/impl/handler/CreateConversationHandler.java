package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.dao.api.entities.messenger.ConversationMemberEntity;
import com.softgroup.common.dao.api.service.ConversationDaoService;
import com.softgroup.common.dao.api.service.ConversationMemberDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.exceptions.MapperException;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.common.utility.time.TimeStampUtil;
import com.softgroup.messenger.api.dto.ConversationDto;
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
    private ConversationMemberDaoService conversationMemberDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_CREATE_CONVERSATION_NAME;
    }

    @Override
    public Response<CreateConversationResponseData> commandHandle(Request<CreateConversationRequestData> request) {
        CreateConversationResponseData responseData = null;
        ResponseStatus responseStatus = ResponseStatus.OK;

        try {
            CreateConversationRequestData requestData =
                    new JacksonDataMapper().convert((Map<String, Object>) request.getData(), CreateConversationRequestData.class );

            String conversationId = UUID.randomUUID().toString();

            ConversationEntity conversation = new ConversationEntity();
            conversation.setId( conversationId );
            conversation.setName( "" );
            conversation.setAdminId( request.getCredential().getUserId() );
            conversation.setLogoImageUri( "" );
            conversation.setType( requestData.getType() );
            conversation.setExists( true );
            conversation.setCreateDate( TimeStampUtil.current());
            conversation.setLastMessageIndex( 0L );

            conversationDaoService.save( conversation );

            for (String memberId : requestData.getMembersIds()) {
                String conversationMemberId = UUID.randomUUID().toString();

                ConversationMemberEntity conversationMember = new ConversationMemberEntity();
                conversationMember.setId( conversationMemberId );
                conversationMember.setConversationId( conversationId );
                conversationMember.setUserId( memberId );
                conversationMember.setLastMessageIndex( 0L );
                conversationMember.setDeletedUser( false );
                conversationMember.setJoinDateUser( TimeStampUtil.current() );

                conversationMemberDaoService.save( conversationMember );
            }

            ConversationDto conversationDto = new ConversationDto();
            conversationDto.setId( conversationId );
            conversationDto.setName( "" );
            conversationDto.setLogoImageUri( "" );
            conversationDto.setType( requestData.getType() );
            conversationDto.setLastMessageIndex( 0L );

            responseData = new CreateConversationResponseData();
            responseData.setConversationDto( conversationDto );

        } catch (MapperException e) {
            responseStatus = ResponseStatus.BAD_REQUEST;
        }

        return ResponseFactory.create( request, responseData, responseStatus );
    }
}