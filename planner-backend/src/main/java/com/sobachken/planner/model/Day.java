package com.sobachken.planner.model;

import com.sobachken.planner.model.enums.Days;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Day extends PanacheEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private Days name;

    @Column(name = "day_date",
    columnDefinition = "timestamp with time zone")
    private LocalDate dayDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_id",
            foreignKey = @ForeignKey(name = "event_day_fk"),
            updatable = false,
            columnDefinition = "uuid")
    private List<Event> events;
}
