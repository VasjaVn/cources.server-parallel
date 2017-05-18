package com.softgroup.common.dao.api.service;

import com.softgroup.common.dao.api.entities.messenger.ConversationDetailsEntity;

import java.util.List;

public interface ConversationDetailsDaoService {
    ConversationDetailsEntity findById(String id);
    List<ConversationDetailsEntity> findByConversationId(String conversationId);

    ConversationDetailsEntity save(ConversationDetailsEntity conversationDetailsEntity);

    void delete(String id);
}