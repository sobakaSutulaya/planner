package com.sobachken.planner.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Goal extends PanacheEntity {

    private String name;
    private String description;
    @Column(name = "expected_date")
    private LocalDate expectedAccomplishDate;
    @Column(name = "actual_date")
    private LocalDate actualAccomplishDate;
    private boolean accomplished;
}
