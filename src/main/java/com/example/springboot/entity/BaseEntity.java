package com.example.springboot.entity;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements java.io.Serializable {

    private static final long serialVersionUID = -2420979951576787924L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME",columnDefinition="timestamp default CURRENT_TIMESTAMP")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME",columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;

    protected BaseEntity() {
    }
}
