package com.sobachken.planner.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Week extends PanacheEntity {

    private final static int DAYS_IN_A_WEEK = 7;

    @Getter
    @OneToMany
    private Set<Day> days = new HashSet<>(DAYS_IN_A_WEEK);
    @Getter
    @Setter
    @OneToMany
    private List<Note> notes;

}
