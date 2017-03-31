package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.authorization.DeviceEntity;
import com.softgroup.common.dao.api.service.DeviceDaoService;
import com.softgroup.common.dao.impl.repository.authorization.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceDaoServiceImpl implements DeviceDaoService {

    @Autowired
    private DeviceRepository repository;

    @Override
    public DeviceEntity findById(String id) {
        return repository.findOne(id);
    }

    @Override
    public DeviceEntity save(DeviceEntity deviceEntity) {
        return repository.save(deviceEntity);
    }
}
