package com.softgroup.common.dao.api.entities.authorization;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_device")
public class DeviceEntity implements Serializable {

    private static final long serialVersionUID = 4067827844599540503L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "last_confirm_date")
    private long lastConfirmDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getLastConfirmDate() {
        return lastConfirmDate;
    }

    public void setLastConfirmDate(long lastConfirmDate) {
        this.lastConfirmDate = lastConfirmDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceEntity that = (DeviceEntity) o;
        return lastConfirmDate == that.lastConfirmDate &&
                Objects.equals(id, that.id) &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deviceId, userId, lastConfirmDate);
    }
}