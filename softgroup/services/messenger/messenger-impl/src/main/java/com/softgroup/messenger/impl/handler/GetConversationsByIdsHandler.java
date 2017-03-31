package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.dao.api.service.ConversationDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.messenger.api.message.GetConversationsByIdsRequestData;
import com.softgroup.messenger.api.message.GetConversationsByIdsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class GetConversationsByIdsHandler
        extends AbstractRequestHandler<GetConversationsByIdsRequestData, GetConversationsByIdsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATIONS_BY_IDS_NAME = "get_conversations_by_ids";

    @Autowired
    private ConversationDaoService conversationDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATIONS_BY_IDS_NAME;
    }

    @Override
    public Response<GetConversationsByIdsResponseData> commandHandle(Request<GetConversationsByIdsRequestData> request) {
        ResponseStatus responseStatus = ResponseStatus.BAD_REQUEST;
        GetConversationsByIdsResponseData responseData = null;

        GetConversationsByIdsRequestData requestData =
                new JacksonDataMapper().convert((Map<String, Object>) request.getData(), GetConversationsByIdsRequestData.class );

        List<String> conversationsIds = requestData.getConversationsIds();

        if ( conversationsIds != null & !conversationsIds.isEmpty() ) {
            List<ConversationEntity> conversations = new ArrayList<>();
            for ( String conversationId : conversationsIds ) {
                ConversationEntity conversation = conversationDaoService.findById( conversationId );
                if ( conversation != null ) {
                    conversations.add( conversation );
                }
            }

            responseData = new GetConversationsByIdsResponseData();
            responseData.setConversations( conversations );

            responseStatus = ResponseStatus.OK;
        }

        return ResponseFactory.create( request, responseData, responseStatus );
    }
}