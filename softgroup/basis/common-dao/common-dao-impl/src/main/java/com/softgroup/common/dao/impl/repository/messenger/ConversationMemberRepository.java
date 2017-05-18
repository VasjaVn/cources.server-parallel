package com.softgroup.common.dao.impl.repository.messenger;

import com.softgroup.common.dao.api.entities.messenger.ConversationMemberEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ConversationMemberRepository extends PagingAndSortingRepository<ConversationMemberEntity, String> {

    List<ConversationMemberEntity> findByConversationId(String conversationId);
}