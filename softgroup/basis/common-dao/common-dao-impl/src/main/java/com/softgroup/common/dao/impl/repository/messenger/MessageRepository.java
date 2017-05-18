package com.softgroup.common.dao.impl.repository.messenger;


import com.softgroup.common.dao.api.entities.messenger.MessageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageRepository extends PagingAndSortingRepository<MessageEntity, Long> {
}
