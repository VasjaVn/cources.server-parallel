package com.softgroup.common.dao.api.entities.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_profile")
public class ProfileEntity implements Serializable {
    private static final long serialVersionUID = -4214474377467299967L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "create_date_time")
    private long createDateTime;

    @Column(name = "update_date_time")
    private long updateDateTime;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "avatar_uri")
    private String avatarUri;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(long createDateTime) {
        this.createDateTime = createDateTime;
    }

    public long getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(long updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileEntity entity = (ProfileEntity) o;
        return createDateTime == entity.createDateTime &&
                updateDateTime == entity.updateDateTime &&
                Objects.equals(id, entity.id) &&
                Objects.equals(phoneNumber, entity.phoneNumber) &&
                Objects.equals(name, entity.name) &&
                Objects.equals(status, entity.status) &&
                Objects.equals(avatarUri, entity.avatarUri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumber, createDateTime, updateDateTime, name, status, avatarUri);
    }
}