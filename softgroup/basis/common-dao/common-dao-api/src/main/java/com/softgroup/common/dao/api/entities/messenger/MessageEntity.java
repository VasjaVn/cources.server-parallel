package com.softgroup.common.dao.api.entities.messenger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "tbl_message")
public class MessageEntity implements Serializable {

    private static final long serialVersionUID = 2020945978485514210L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "sender_id")
    private String senderId;

    @Column(name = "type")
    private int type;

    @Column(name = "payload")
    private byte[] payload;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "server_receive_time")
    private Long serverReceiveTime;

    @Column(name = "message_index")
    private Long messageIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getServerReceiveTime() {
        return serverReceiveTime;
    }

    public void setServerReceiveTime(Long serverReceiveTime) {
        this.serverReceiveTime = serverReceiveTime;
    }

    public Long getMessageIndex() {
        return messageIndex;
    }

    public void setMessageIndex(Long messageIndex) {
        this.messageIndex = messageIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return type == that.type &&
                Objects.equals(id, that.id) &&
                Objects.equals(conversationId, that.conversationId) &&
                Objects.equals(senderId, that.senderId) &&
                Arrays.equals(payload, that.payload) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(serverReceiveTime, that.serverReceiveTime) &&
                Objects.equals(messageIndex, that.messageIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conversationId, senderId, type, payload, createTime, serverReceiveTime, messageIndex);
    }
}