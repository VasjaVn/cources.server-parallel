package com.softgroup.common.dao.impl.repository.profile;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProfileRepository extends PagingAndSortingRepository<ProfileEntity, String> {
}
