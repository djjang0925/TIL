package com.example.crudpractice.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp // 생성시간
    @Column(updatable = false) // 수정시에는 관여 x
    private LocalDateTime createdTime;

    @UpdateTimestamp // 수정시간
    @Column(insertable = false) // 입력시 관여 x
    private LocalDateTime updatedTime;
}
