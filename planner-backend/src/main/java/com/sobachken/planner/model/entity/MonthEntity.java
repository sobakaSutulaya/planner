package com.sobachken.planner.model.entity;

import com.sobachken.planner.model.entity.note.MonthNoteEntity;
import com.sobachken.planner.model.enums.MonthEnum;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "month")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MonthEntity extends BaseEntity {

    private final static int WEEKS = 5;//4 week and 3 days average

    @Getter
    private MonthEnum name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_id",
            updatable = false,
            nullable = false,
            columnDefinition = "uuid",
            foreignKey = @ForeignKey(name = "month_week_fk"))
    private Set<WeekEntity> weeks = new HashSet<>(WEEKS);

    @ElementCollection
    @CollectionTable(name = "month_note",
            joinColumns = @JoinColumn(name = "month_id",
                    updatable = false,
                    nullable = false,
                    columnDefinition = "uuid"),
            foreignKey = @ForeignKey(name = "month_note_fk"))
    private Set<MonthNoteEntity> notes;
}
