package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.messenger.ConversationMemberEntity;
import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.dao.api.service.ConversationMemberDaoService;
import com.softgroup.common.dao.api.service.ProfileDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.messenger.api.message.GetConversationDetailsRequestData;
import com.softgroup.messenger.api.message.GetConversationDetailsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GetConversationDetailsHandler
        extends AbstractRequestHandler<GetConversationDetailsRequestData, GetConversationDetailsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATION_DETAILS_NAME = "get_conversation_details";

    @Autowired
    private ProfileDaoService profileDaoService;

    @Autowired
    private ConversationMemberDaoService conversationMemberDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATION_DETAILS_NAME;
    }

    @Override
    public Response<GetConversationDetailsResponseData> commandHandle(Request<GetConversationDetailsRequestData> request) {
        GetConversationDetailsRequestData requestData =
                new JacksonDataMapper().convert((Map<String, Object>) request.getData(), GetConversationDetailsRequestData.class);

        String conversationId = requestData.getConversationId();

        List<ConversationMemberEntity> listEntities =
                conversationMemberDaoService.findByConversationId( conversationId );

        GetConversationDetailsResponseData responseData = null;
        ResponseStatus responseStatus = ResponseStatus.BAD_REQUEST;

        if ( listEntities != null ) {
            List<ProfileEntity> members = new ArrayList<>();
            for ( ConversationMemberEntity entity : listEntities ) {
                String userId = entity.getUserId();
                System.out.println( "userId = " + userId );

                ProfileEntity profileEntity = profileDaoService.findById(userId);
                if ( profileEntity != null ) {
                    members.add( profileEntity );
                }
            }

            responseData = new GetConversationDetailsResponseData();
            responseData.setId( conversationId );
            responseData.setMembers( members );
            responseStatus = ResponseStatus.OK;
        }

        return ResponseFactory.create(request, responseData, responseStatus);
    }
}