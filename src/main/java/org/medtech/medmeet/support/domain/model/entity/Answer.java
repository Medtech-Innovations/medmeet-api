package org.medtech.medmeet.support.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;


@Table(name = "answers")
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 80)
    @Column(name = "answer", nullable = false, columnDefinition = "varchar(80)")
    private String content;

    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date dates;

    @OneToMany(mappedBy = "answer")
    private ArrayList<Category> categories;



}
