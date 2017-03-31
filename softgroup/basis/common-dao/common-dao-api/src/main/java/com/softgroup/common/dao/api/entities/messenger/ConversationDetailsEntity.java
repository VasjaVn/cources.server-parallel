package com.softgroup.common.dao.api.entities.messenger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_conversation_details")
public class ConversationDetailsEntity implements Serializable {
    private static final long serialVersionUID = -4054443996056524736L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "conversation_id")
    private String conversationId;

    @Column(name = "member_id")
    private String memberId;

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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationDetailsEntity entity = (ConversationDetailsEntity) o;
        return Objects.equals(id, entity.id) &&
                Objects.equals(conversationId, entity.conversationId) &&
                Objects.equals(memberId, entity.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conversationId, memberId);
    }
}