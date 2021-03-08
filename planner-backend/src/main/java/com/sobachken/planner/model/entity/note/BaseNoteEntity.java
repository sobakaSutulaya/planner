package com.sobachken.planner.model.entity.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@MappedSuperclass
public abstract class BaseNoteEntity {

    @Column(name = "name", columnDefinition = "varchar(32)")
    private String name;

    @Column(name = "description", columnDefinition = "varchar(150)")
    private String description;
}
