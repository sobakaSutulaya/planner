package com.sobachken.planner.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Planner extends PanacheEntity {

    private static final int MONTH_IN_A_YEAR = 12;

    @Getter
    @OneToMany
    private Set<Month> months = new HashSet<>(MONTH_IN_A_YEAR);
    @Getter
    @Setter
    @OneToMany
    private List<Goal> goals;
    @Getter
    @Setter
    @OneToMany
    private List<Note> notes;
}
