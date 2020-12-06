package com.sobachken.planner.model;

import com.sobachken.planner.model.enums.MontName;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "month_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Month extends PanacheEntity {

    @Getter
    private MontName name;
    @OneToMany
    private Set<Week> weeks;
    @OneToMany
    private List<Note> notes;
}
