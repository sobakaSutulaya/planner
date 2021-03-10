package com.sobachken.planner.model.entity;

import com.sobachken.planner.model.entity.note.MonthNoteEntity;
import com.sobachken.planner.model.enums.MonthEnum;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Month")
@Table(name = "month",
        indexes = {
                @Index(name = "year_month_fk_uindex", columnList = "year_id")
        })
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NamedEntityGraphs({
        @NamedEntityGraph(name = MonthEntity.FULL_GRAPH,
                attributeNodes = {
                        @NamedAttributeNode(value = "name"),
                        @NamedAttributeNode(value = "weeks", subgraph = WeekEntity.FULL_GRAPH),
                        @NamedAttributeNode(value = "notes")
                })
})
public class MonthEntity extends BaseEntity {

    private final static int WEEKS = 5;//4 week and 3 days average

    public static final String FULL_GRAPH = "FullMonthGraph";

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
