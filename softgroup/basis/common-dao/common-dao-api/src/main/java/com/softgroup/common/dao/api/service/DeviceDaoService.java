package com.softgroup.common.dao.api.service;

import com.softgroup.common.dao.api.entities.authorization.DeviceEntity;

public interface DeviceDaoService {
    DeviceEntity findById(String id);
    DeviceEntity save(DeviceEntity deviceEntity);
}
