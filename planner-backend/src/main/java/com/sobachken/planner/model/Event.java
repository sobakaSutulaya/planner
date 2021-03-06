package com.sobachken.planner.model;

import com.sobachken.planner.model.enums.Priority;
import com.sun.istack.Nullable;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Event extends PanacheEntity {

    @Column(name = "name",
            columnDefinition = "varchar(32)")
    private String name;

    @Column(name = "description",
            columnDefinition = "varchar(150)")
    private String description;

    @Nullable
    @Column(name = "start_time",
            columnDefinition = "timestamp with time zone")
    private LocalDateTime startTime;

    @Nullable
    @Enumerated(EnumType.STRING)
    @Column(name = "priority",
            columnDefinition = "varchar(16)")
    private Priority priority;

    @Column(name = "is_completed",
            columnDefinition = "boolean")
    private boolean completed;
}
