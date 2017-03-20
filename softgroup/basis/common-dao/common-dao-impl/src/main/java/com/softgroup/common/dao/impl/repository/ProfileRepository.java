package com.softgroup.common.dao.impl.repository;

import com.softgroup.common.dao.api.entities.profile.ProfileEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends PagingAndSortingRepository<ProfileEntity, String> {

    ProfileEntity findById(String id);

    List<ProfileEntity> findByName(String name);
}
