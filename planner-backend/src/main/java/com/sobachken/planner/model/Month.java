package com.sobachken.planner.model;

import com.sobachken.planner.model.enums.Months;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "month_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Month extends PanacheEntity {

    @Getter
    private Months name;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_id",
            updatable = false,
            columnDefinition = "uuid",
            foreignKey = @ForeignKey(name = "month_plan_week_fk"))
    private Set<Week> weeks;

    @ElementCollection
    @JoinColumn(name = "month_plan_id",
    updatable = false,
    foreignKey = @ForeignKey(name = "month_plan_note_fk"))
    private Set<Note> notes = new HashSet<>();
}
