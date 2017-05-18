package com.softgroup.common.dao.impl.repository.messenger;

import com.softgroup.common.dao.api.entities.messenger.ConversationDetailsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ConversationDetailsRepository extends PagingAndSortingRepository<ConversationDetailsEntity, String> {
    List<ConversationDetailsEntity> findByConversationId(String conversationId);
}