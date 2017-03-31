package com.softgroup.common.dao.api.service;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;

import java.util.List;

public interface ConversationDaoService {
    ConversationEntity findById(String id);
    List<ConversationEntity> findByType(Integer type);
    List<ConversationEntity> findAll();
    ConversationEntity save(ConversationEntity conversationEntity);
    void delete(String id);
}