package com.softgroup.common.dao.impl.service.profile;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import com.softgroup.common.dao.api.service.profile.ProfileDaoService;
import com.softgroup.common.dao.impl.repository.ProfileRepository;
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
}
