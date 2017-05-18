package com.softgroup.common.dao.impl.repository.messenger;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ConversationRepository extends PagingAndSortingRepository<ConversationEntity, String> {

    List<ConversationEntity> findByType(Integer type);

    List<ConversationEntity> findAll();
}