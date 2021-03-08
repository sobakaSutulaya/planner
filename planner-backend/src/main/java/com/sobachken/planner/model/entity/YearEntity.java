package com.sobachken.planner.model.entity;

import com.sobachken.planner.model.entity.note.YearNoteEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "year")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class YearEntity extends BaseEntity {

    //todo: add EntityGraphs
    //todo: add backend to docker-compose
    private static final int MONTH_IN_A_YEAR = 12;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {REFRESH, REMOVE})
    @JoinColumn(name = "year_id",
            updatable = false,
            foreignKey = @ForeignKey(name = "year_month_fk"))
    private Set<MonthEntity> months = new HashSet<>(MONTH_IN_A_YEAR);

    @Setter
    @OneToMany(fetch = FetchType.LAZY,
            cascade = {REFRESH, REMOVE})
    @JoinColumn(name = "year_id",
            updatable = false,
            nullable = false,
            foreignKey = @ForeignKey(name = "year_goal_fk"))
    private List<GoalEntity> goals;

    @Setter
    @ElementCollection
    @CollectionTable(name = "year_notes",
            joinColumns = @JoinColumn(name = "year_id",
                    nullable = false,
                    updatable = false,
                    columnDefinition = "uuid"),
            foreignKey = @ForeignKey(name = "year_note_fk")
    )
    private List<YearNoteEntity> notes;
}
