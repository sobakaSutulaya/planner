package com.sobachken.planner.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Year extends PanacheEntity {

    //todo: add EntityGraphs
    //todo: add nullable=false everywhere where updatable=false is used
    //todo: add backend to docker-compose
    private static final int MONTH_IN_A_YEAR = 12;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {REFRESH, REMOVE})
    @JoinColumn(name = "year_id",
            updatable = false,
            foreignKey = @ForeignKey(name = "year_month_fk"))
    private final Set<Month> months = new HashSet<>(MONTH_IN_A_YEAR);

    @Setter
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {REFRESH, REMOVE})
    @JoinColumn(name = "year_id",
            updatable = false,
            foreignKey = @ForeignKey(name = "year_goal_fk"))
    private List<Goal> goals;

    @Setter
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {REFRESH, REMOVE})
    @JoinColumn(name = "year_id",
    updatable = false,
    nullable = false,
    columnDefinition = "uuid",
    foreignKey = @ForeignKey(name = "year_note_fk"))
    private List<Note> notes;
}
