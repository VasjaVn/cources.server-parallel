package com.softgroup.common.dao.api.entities.messenger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_conversation")
public class ConversationEntity implements Serializable {

    private static final long serialVersionUID = -8269920454650981449L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private int type;

    @Column(name = "logo_image_uri")
    private String logoImageUri;

    @Column(name = "admin_id")
    private String adminId;

    @Column(name = "exists")
    private boolean exists;

    @Column(name = "create_date")
    private Long createDate;

    @Column(name = "last_message_index")
    private Long lastMessageIndex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLogoImageUri() {
        return logoImageUri;
    }

    public void setLogoImageUri(String logoImageUri) {
        this.logoImageUri = logoImageUri;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getLastMessageIndex() {
        return lastMessageIndex;
    }

    public void setLastMessageIndex(Long lastMessageIndex) {
        this.lastMessageIndex = lastMessageIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationEntity that = (ConversationEntity) o;
        return type == that.type &&
                exists == that.exists &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(logoImageUri, that.logoImageUri) &&
                Objects.equals(adminId, that.adminId) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(lastMessageIndex, that.lastMessageIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, logoImageUri, adminId, exists, createDate, lastMessageIndex);
    }
}