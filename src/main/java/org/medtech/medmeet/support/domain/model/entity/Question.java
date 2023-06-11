package org.medtech.medmeet.support.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    @Column(name = "first_name", length = 30)
    private String firstName;

    @Size(min = 3, max = 80)
    @Column(name = "question_text", nullable = false, columnDefinition = "TEXT")
    private String question_text;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
}
