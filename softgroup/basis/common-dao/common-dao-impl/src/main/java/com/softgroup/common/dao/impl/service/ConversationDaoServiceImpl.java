package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.messenger.ConversationEntity;
import com.softgroup.common.dao.api.service.ConversationDaoService;
import com.softgroup.common.dao.impl.repository.messenger.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationDaoServiceImpl implements ConversationDaoService {

    @Autowired
    private ConversationRepository repository;

    @Override
    public ConversationEntity findById(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<ConversationEntity> findByType(Integer type) {
        return repository.findByType(type);
    }

    @Override
    public List<ConversationEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ConversationEntity save(ConversationEntity conversationEntity) {
        return repository.save(conversationEntity);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }
}