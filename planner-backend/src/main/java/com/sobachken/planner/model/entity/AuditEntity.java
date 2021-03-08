package com.sobachken.planner.model.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class AuditEntity {

    @Column(name = "created_at", columnDefinition = "timestamp with time zone")
    private LocalDateTime createdAt;
    @Column(name = "modified_when", columnDefinition = "timestamp with time zone")
    private LocalDateTime modifiedWhen;
    //may be with security add the modifiedBy field

}
