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
import com.softgroup.messenger.api.dto.ConversationDto;
import com.softgroup.messenger.api.message.GetConversationsRequestData;
import com.softgroup.messenger.api.message.GetConversationsResponseData;
import com.softgroup.messenger.api.router.MessengerRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GetConversationsHandler
        extends AbstractRequestHandler<GetConversationsRequestData, GetConversationsResponseData>
        implements MessengerRequestHandler
{
    private static final String MSNG_CMD_GET_CONVERSATIONS_NAME = "get_conversations";

    private static final Integer INDIVIDUAL_CONVERSATION_TYPE = 0;
    private static final Integer GROUP_CONVERSATION_TYPE = 1;
    private static Set<Integer> conversationTypes;

    static {
        conversationTypes = new HashSet<>();
        conversationTypes.add( INDIVIDUAL_CONVERSATION_TYPE );
        conversationTypes.add( GROUP_CONVERSATION_TYPE );
    }

    @Autowired
    private ConversationDaoService conversationDaoService;

    @Override
    public String getName() {
        return MSNG_CMD_GET_CONVERSATIONS_NAME;
    }

    @Override
    public Response<GetConversationsResponseData> commandHandle(Request<GetConversationsRequestData> request) {
        ResponseStatus responseStatus = ResponseStatus.BAD_REQUEST;
        GetConversationsResponseData responseData = null;

        try {
            GetConversationsRequestData requestData =
                    new JacksonDataMapper().convert((Map<String, Object>) request.getData(), GetConversationsRequestData.class);

            Integer type = requestData.getType();

            List<ConversationEntity> conversationEntities = null;
            if ( type != null ) {
                if ( conversationTypes.contains( type ) ) {
                    conversationEntities = conversationDaoService.findByType( type );
                }
            } else {
                conversationEntities = conversationDaoService.findAll();
            }

            if ( conversationEntities != null ) {
                List<ConversationDto> listConversationDto = new ArrayList<>();
                for ( ConversationEntity conversationEntity : conversationEntities  ) {

                    ConversationDto conversationDto = new ConversationDto();
                    conversationDto.setId( conversationEntity.getId() );
                    conversationDto.setName( conversationEntity.getName() );
                    conversationDto.setType( conversationEntity.getType() );
                    conversationDto.setLogoImageUri( conversationEntity.getLogoImageUri() );
                    conversationDto.setLastMessageIndex( conversationEntity.getLastMessageIndex() );

                    listConversationDto.add( conversationDto );
                }

                responseData = new GetConversationsResponseData();
                responseData.setConversations( listConversationDto );

                responseStatus = ResponseStatus.OK;
            }

        } catch (MapperException e) {
            // NOP
        }

        return ResponseFactory.create( request, responseData, responseStatus );
    }
}