package com.softgroup.common.dao.impl.repository.authorization;

import com.softgroup.common.dao.api.entities.authorization.DeviceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DeviceRepository extends PagingAndSortingRepository<DeviceEntity, String> {
}
