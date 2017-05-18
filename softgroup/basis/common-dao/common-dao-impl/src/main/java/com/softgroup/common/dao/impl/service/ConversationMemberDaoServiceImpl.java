package com.softgroup.common.dao.impl.service;

import com.softgroup.common.dao.api.entities.messenger.ConversationMemberEntity;
import com.softgroup.common.dao.api.service.ConversationMemberDaoService;
import com.softgroup.common.dao.impl.repository.messenger.ConversationMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationMemberDaoServiceImpl implements ConversationMemberDaoService {

    @Autowired
    private ConversationMemberRepository repository;

    @Override
    public ConversationMemberEntity findById(String id) {
        return repository.findOne(id);
    }

    @Override
    public List<ConversationMemberEntity> findByConversationId(String conversationId) {
        return repository.findByConversationId(conversationId);
    }

    @Override
    public ConversationMemberEntity save(ConversationMemberEntity conversationMemberEntity) {
        return repository.save(conversationMemberEntity);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

}