package com.sobachken.planner.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Week extends PanacheEntity {

    private final static int DAYS_IN_A_WEEK = 7;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {REFRESH, REMOVE})
    @JoinColumn(name = "week_id",
    updatable = false,
    foreignKey = @ForeignKey(name = "week_day_fk"))
    private final Set<Day> days = new HashSet<>(DAYS_IN_A_WEEK);

    @OneToMany(fetch = FetchType.LAZY,
    cascade = {REFRESH, REMOVE})
    @JoinColumn(name = "week_id",
    updatable = false,
    foreignKey = @ForeignKey(name = "week_note_fk"))
    private List<Note> notes;

}
