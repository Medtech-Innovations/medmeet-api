package org.medtech.medmeet.support.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Integer id;

    @Size(min = 3, max = 12)
    @Column(name = "category_questions", nullable = false, columnDefinition = "varchar(12)")
    private String name;

    @Size(min = 3, max = 80)
    @Column(name = "define_quest", nullable = false, columnDefinition = "TEXT")
    private String define;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private ArrayList<Question> questions;

    @ManyToOne
    @JoinColumn(name="answer_id")
    private Answer answer;
}
