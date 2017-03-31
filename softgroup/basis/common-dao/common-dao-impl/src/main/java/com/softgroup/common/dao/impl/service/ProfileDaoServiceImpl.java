package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.dao.api.service.ProfileDaoService;
import com.softgroup.common.dao.impl.repository.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileDaoServiceImpl implements ProfileDaoService {

    @Autowired
    private ProfileRepository repository;

    @Override
    public ProfileEntity findById(String id) {
        return repository.findOne(id);
    }

    @Override
    public ProfileEntity save(ProfileEntity profileEntity) {
        return repository.save(profileEntity);
    }
}