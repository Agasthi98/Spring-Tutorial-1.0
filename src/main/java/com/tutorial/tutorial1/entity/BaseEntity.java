package com.tutorial.tutorial1.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @UpdateTimestamp
    private LocalDateTime updatedDateTime;
    @CreationTimestamp
    private LocalDateTime createdDateTime;
}
