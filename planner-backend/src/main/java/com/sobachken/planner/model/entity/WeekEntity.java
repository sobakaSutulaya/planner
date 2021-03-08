package com.sobachken.planner.model.entity;

import com.sobachken.planner.model.entity.note.WeekNoteEntity;
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
@Table(name = "week")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WeekEntity extends BaseEntity {

    private final static int DAYS_IN_A_WEEK = 7;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {REFRESH, REMOVE})
    @JoinColumn(name = "week_id",
            updatable = false,
            nullable = false,
            columnDefinition = "uuid",
            foreignKey = @ForeignKey(name = "week_day_fk"))
    private Set<DayEntity> days = new HashSet<>(DAYS_IN_A_WEEK);

    @ElementCollection
    @CollectionTable(name = "week_note",
            joinColumns = @JoinColumn(name = "week_id",
                    updatable = false,
                    nullable = false,
                    columnDefinition = "uuid"
            ),
            foreignKey = @ForeignKey(name = "week_note_fk"))
    private List<WeekNoteEntity> notes;

}
