package com.sobachken.planner.model;

import com.sobachken.planner.model.enums.DayName;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Day extends PanacheEntity {

    @Getter
    private DayName name;
    @Column(name = "day_date")
    private LocalDate dayDate;
    @OneToMany
    private List<Event> events;
}
