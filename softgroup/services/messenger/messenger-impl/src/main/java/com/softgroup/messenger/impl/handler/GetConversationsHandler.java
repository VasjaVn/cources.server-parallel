package com.softgroup.messenger.impl.handler;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.dao.api.service.ConversationDaoService;
import com.softgroup.common.datamapper.JacksonDataMapper;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.common.router.api.AbstractRequestHandler;
import com.softgroup.common.utility.response.ResponseFactory;
import com.softgroup.common.utility.response.ResponseStatus;
import com.softgroup.messenger.api.message.GetConversationsRequestData;
import com.softgroup.messenger.api.message.GetConversationsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class GetConversationsHandler
        extends AbstractRequestHandler<GetConversationsRequestData, GetConversationsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATIONS_NAME = "get_conversations";

    private static final Integer INDIVIDUAL_TYPE = 0;
    private static final Integer GROUP_TYPE = 1;
    private static Set<Integer> setValueTypes;

    static {
        setValueTypes = new HashSet<>();
        setValueTypes.add(INDIVIDUAL_TYPE);
        setValueTypes.add(GROUP_TYPE);
    }

    @Autowired
    private ConversationDaoService conversationDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATIONS_NAME;
    }

    @Override
    public Response<GetConversationsResponseData> commandHandle(Request<GetConversationsRequestData> request) {
        GetConversationsRequestData requestData =
                new JacksonDataMapper().convert((Map<String, Object>) request.getData(), GetConversationsRequestData.class);

        Integer type = requestData.getType();

        List<ConversationEntity> conversations = null;
        ResponseStatus responseStatus = ResponseStatus.OK;
        if ( type != null ) {
            if ( setValueTypes.contains(type) ) {
                conversations = conversationDaoService.findByType(type);
            } else {
                responseStatus = ResponseStatus.BAD_REQUEST;
            }
        } else {
            conversations = conversationDaoService.findAll();
        }

        GetConversationsResponseData responseData = new GetConversationsResponseData();
        responseData.setConversations( conversations );

        return ResponseFactory.create( request, responseData, responseStatus );
    }
}