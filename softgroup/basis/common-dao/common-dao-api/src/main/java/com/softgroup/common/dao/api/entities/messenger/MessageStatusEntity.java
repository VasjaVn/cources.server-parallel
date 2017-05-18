package com.softgroup.common.dao.api.entities.messenger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_message_status")
public class MessageStatusEntity implements Serializable {

    private static final long serialVersionUID = -8727596773563823385L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "status_update_date")
    private Long statusUpdateDate;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "sender_id")
    private String senderId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getStatusUpdateDate() {
        return statusUpdateDate;
    }

    public void setStatusUpdateDate(Long statusUpdateDate) {
        this.statusUpdateDate = statusUpdateDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageStatusEntity that = (MessageStatusEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(messageId, that.messageId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(statusUpdateDate, that.statusUpdateDate) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(senderId, that.senderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageId, status, statusUpdateDate, userId, senderId);
    }
}