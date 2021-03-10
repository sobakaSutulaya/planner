package com.sobachken.planner.model.entity;

import com.sobachken.planner.model.entity.note.YearNoteEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.REMOVE;



@Entity(name = "Year")
@Table(name = "year")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NamedEntityGraphs({
        @NamedEntityGraph(name = YearEntity.FULL_GRAPH,
                attributeNodes = {
                        @NamedAttributeNode(value = "months", subgraph = MonthEntity.FULL_GRAPH),
                        //todo: i don't know should i specify all of it, or it will be included by default
                        @NamedAttributeNode(value = "goals"),
                        @NamedAttributeNode(value = "notes")
                })
})
public class YearEntity extends BaseEntity {

    public static final String FULL_GRAPH = "FullYearGraph";

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
