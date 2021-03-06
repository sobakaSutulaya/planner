package com.sobachken.planner.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Embeddable
public class Note extends PanacheEntity {

    @Column(name = "name", columnDefinition = "varchar(32)")
    private String name;

    @Column(name = "description", columnDefinition = "varchar(150)")
    private String description;
}
