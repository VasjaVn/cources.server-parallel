package com.softgroup.common.dao.api.service;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;

public interface ProfileDaoService {
    ProfileEntity findById(String id);
    ProfileEntity save(ProfileEntity profileEntity);
}
