package com.sobachken.planner.model;

import com.sobachken.planner.model.enums.Priority;
import com.sun.istack.Nullable;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Event extends PanacheEntity {

    private String name;
    private String description;
    @Nullable
    @Column(name = "start_time")
    private LocalDateTime startTime;
    @Nullable
    private Priority priority;
    private boolean completed;
}
