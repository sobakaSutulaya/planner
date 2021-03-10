package com.sobachken.planner.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "Goal")
@Table(name = "goal",
        indexes = {
                @Index(name = "year_goal_fk_uindex", columnList = "year_id")
        })
public class GoalEntity extends BaseEntity {

    @Column(name = "name",
            columnDefinition = "varchar(32)")
    private String name;

    @Column(name = "description",
            columnDefinition = "varchar(150)")
    private String description;

    @Column(name = "expected_date",
            columnDefinition = "timestamp with time zone")
    private LocalDate expectedAccomplishDate;

    @Column(name = "actual_date",
            columnDefinition = "timestamp with time zone")
    private LocalDate actualAccomplishDate;

    @Column(name = "is_accomplished", columnDefinition = "boolean")
    private boolean accomplished;
}
