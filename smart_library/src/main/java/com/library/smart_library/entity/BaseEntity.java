package com.library.smart_library.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {

    private Date created_time;
    private Date modified_time;
    private String is_delete;

    public BaseEntity() {
    }

    public BaseEntity(Date created_time, Date modified_time, String is_delete) {
        this.created_time = created_time;
        this.modified_time = modified_time;
        this.is_delete = is_delete;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    public String getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(String is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "created_time=" + created_time +
                ", modified_time=" + modified_time +
                ", is_delete='" + is_delete + '\'' +
                '}';
    }
}
