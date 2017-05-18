package com.softgroup.common.dao.impl.repository.messenger;

import com.softgroup.common.dao.api.entities.messenger.MessageStatusEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageStatusRepository extends PagingAndSortingRepository<MessageStatusEntity, String> {
}
