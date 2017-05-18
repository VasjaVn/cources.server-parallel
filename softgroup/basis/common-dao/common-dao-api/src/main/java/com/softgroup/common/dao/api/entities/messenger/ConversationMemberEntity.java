package com.softgroup.common.dao.api.entities.messenger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_conversation_member")
public class ConversationMemberEntity implements Serializable {

    private static final long serialVersionUID = 6183949016026869456L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "last_message_index")
    private Long lastMessageIndex;

    @Column(name = "is_deleted_user")
    private boolean isDeletedUser;

    @Column(name = "join_date_user")
    private Long joinDateUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getLastMessageIndex() {
        return lastMessageIndex;
    }

    public void setLastMessageIndex(Long lastMessageIndex) {
        this.lastMessageIndex = lastMessageIndex;
    }

    public boolean isDeletedUser() {
        return isDeletedUser;
    }

    public void setDeletedUser(boolean deletedUser) {
        isDeletedUser = deletedUser;
    }

    public Long getJoinDateUser() {
        return joinDateUser;
    }

    public void setJoinDateUser(Long joinDateUser) {
        this.joinDateUser = joinDateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationMemberEntity that = (ConversationMemberEntity) o;
        return isDeletedUser == that.isDeletedUser &&
                Objects.equals(id, that.id) &&
                Objects.equals(conversationId, that.conversationId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(lastMessageIndex, that.lastMessageIndex) &&
                Objects.equals(joinDateUser, that.joinDateUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conversationId, userId, lastMessageIndex, isDeletedUser, joinDateUser);
    }
}