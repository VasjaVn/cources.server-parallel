package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.messenger.ConversationDetailsEntity;
import com.softgroup.common.dao.api.service.ConversationDetailsDaoService;
import com.softgroup.common.dao.impl.repository.messenger.ConversationDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationDetailsDaoServiceImpl implements ConversationDetailsDaoService {

    @Autowired
    private ConversationDetailsRepository repository;

    @Override
    public ConversationDetailsEntity findById(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<ConversationDetailsEntity> findByConversationId(String conversationId) {
        return repository.findByConversationId(conversationId);
    }

    @Override
    public ConversationDetailsEntity save(ConversationDetailsEntity conversationDetailsEntity) {
        return repository.save(conversationDetailsEntity);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

}