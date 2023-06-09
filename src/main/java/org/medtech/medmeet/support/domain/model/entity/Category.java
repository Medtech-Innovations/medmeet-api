package org.medtech.medmeet.support.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer id;

    @Size(min = 3, max = 12)
    @Column(name = "category", nullable = false, columnDefinition = "varchar(12)")
    private String name;

    @OneToMany(mappedBy = "category")
    private ArrayList<Question> questions;
}
