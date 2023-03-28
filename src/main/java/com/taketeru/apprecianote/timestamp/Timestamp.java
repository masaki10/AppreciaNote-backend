package com.taketeru.apprecianote.timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.time.Instant;


@MappedSuperclass // JPAエンティティの親クラスに必要
@Data
public abstract class Timestamp {
    @Column(name = "update_time")
    private java.sql.Timestamp updateTime;

    @Column(name = "create_time", updatable = false)
    private java.sql.Timestamp createTime;

    @PrePersist
    public void prePersist() {
        java.sql.Timestamp ts = java.sql.Timestamp.from(Instant.now());
        this.createTime = ts;
        this.updateTime = ts;
    }

    @PreUpdate
    public void preUpdate() {
        this.updateTime = java.sql.Timestamp.from(Instant.now());
    }
}