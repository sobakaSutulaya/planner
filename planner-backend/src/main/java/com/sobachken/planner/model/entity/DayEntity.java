package com.sobachken.planner.model.entity;

import com.sobachken.planner.model.entity.note.DayNoteEntity;
import com.sobachken.planner.model.enums.DayEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "Day")
@Table(name = "day",
        indexes = {
                @Index(name = "week_day_fk_uindex", columnList = "week_id")
        })
@NamedEntityGraphs({
        @NamedEntityGraph(name = DayEntity.FULL_GRAPH,
                attributeNodes = {
                        @NamedAttributeNode(value = "events"),
                        @NamedAttributeNode(value = "notes")
                })
})
public class DayEntity extends BaseEntity {

    public static final String FULL_GRAPH = "FullDayGraph";

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private DayEnum name;

    @Column(name = "day_date",
            columnDefinition = "timestamp with time zone")
    private LocalDate dayDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "day_id",
            foreignKey = @ForeignKey(name = "event_day_fk"),
            updatable = false,
            nullable = false,
            columnDefinition = "uuid")
    private List<EventEntity> events;

    @ElementCollection
    @CollectionTable(name = "day_note",
            joinColumns = @JoinColumn(name = "day_id",
                    updatable = false,
                    insertable = false,
                    columnDefinition = "uuid"),
            foreignKey = @ForeignKey(name = "day_note_fk"))
    private Set<DayNoteEntity> notes;
}
