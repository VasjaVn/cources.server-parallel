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
import com.softgroup.messenger.api.message.DeleteConversationRequestData;
import com.softgroup.messenger.api.message.DeleteConversationResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DeleteConversationHandler
        extends AbstractRequestHandler<DeleteConversationRequestData, DeleteConversationResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_DELETE_CONVERSATION_NAME = "delete_conversation";

    @Autowired
    private ConversationDaoService conversationDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_DELETE_CONVERSATION_NAME;
    }

    @Override
    public Response<DeleteConversationResponseData> commandHandle(Request<DeleteConversationRequestData> request) {
        DeleteConversationResponseData responseData = null;
        ResponseStatus responseStatus = ResponseStatus.BAD_REQUEST;

        try {
            DeleteConversationRequestData requestData =
                    new JacksonDataMapper().convert((Map<String, Object>) request.getData(), DeleteConversationRequestData.class);

            String conversationId = requestData.getConversationId();
            ConversationEntity conversation = conversationDaoService.findById( conversationId );

            if ( conversation != null ) {
                conversation.setExists( false );
                conversationDaoService.save( conversation );
                responseData = new DeleteConversationResponseData();
                responseStatus = ResponseStatus.OK;
            }
        } catch (MapperException e) {
            // NOP
        }

        return ResponseFactory.create( request, responseData, responseStatus );
    }
}