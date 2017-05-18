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
import com.softgroup.messenger.api.message.GetConversationDetailsResponseData;
import com.softgroup.messenger.api.message.GetConversationsDetailsRequestData;
import com.softgroup.messenger.api.message.GetConversationsDetailsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GetConversationsDetailsHandler
        extends AbstractRequestHandler<GetConversationsDetailsRequestData, GetConversationsDetailsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATIONS_DETAILS_NAME = "get_conversations_details";

    @Autowired
    private ProfileDaoService profileDaoService;

    @Autowired
    private ConversationMemberDaoService conversationMemberDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATIONS_DETAILS_NAME;
    }

    @Override
    public Response<GetConversationsDetailsResponseData> commandHandle(Request<GetConversationsDetailsRequestData> request) {
        GetConversationsDetailsRequestData requestData =
                new JacksonDataMapper().convert((Map<String, Object>) request.getData(), GetConversationsDetailsRequestData.class );

        ResponseStatus responseStatus = ResponseStatus.OK;
        GetConversationsDetailsResponseData responseData = new GetConversationsDetailsResponseData();

        List<String> conversationsIds = requestData.getConversationsIds();
        if ( conversationsIds != null & !conversationsIds.isEmpty() ) {

            List<GetConversationDetailsResponseData> conversationsDetails = new ArrayList<>();
            for ( String conversationId : conversationsIds ) {
                System.out.println( "conversation_id: " + conversationId);
                List<ConversationMemberEntity> listEntities = conversationMemberDaoService.findByConversationId(conversationId);

                if ( listEntities == null ) {
                    responseData = null;
                    responseStatus = ResponseStatus.BAD_REQUEST;
                    break;
                }

                List<ProfileEntity> members = new ArrayList<>();
                for ( ConversationMemberEntity entity : listEntities ) {
                    String userId = entity.getUserId();
                    System.out.println( "user_id = " + userId);

                    ProfileEntity profileEntity = profileDaoService.findById( userId );
                    if ( profileEntity != null ) {
                        members.add( profileEntity );
                    }
                }

                GetConversationDetailsResponseData conversationDetails = new GetConversationDetailsResponseData();
                conversationDetails.setId( conversationId );
                conversationDetails.setMembers( members );

                conversationsDetails.add( conversationDetails );
            }

            responseData.setConversationsDetails( conversationsDetails );

        }

        return ResponseFactory.create(request, responseData, responseStatus);
    }
}