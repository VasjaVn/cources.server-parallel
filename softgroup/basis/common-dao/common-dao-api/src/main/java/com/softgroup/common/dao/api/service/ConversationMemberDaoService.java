package com.softgroup.common.dao.api.service;

import com.softgroup.common.dao.api.entities.messenger.ConversationMemberEntity;

import java.util.List;

public interface ConversationMemberDaoService {
    ConversationMemberEntity findById(String id);
    List<ConversationMemberEntity> findByConversationId(String conversationId);

    ConversationMemberEntity save(ConversationMemberEntity conversationMemberEntity);

    void delete(String id);
}