package org.medtech.medmeet.contact.domain.model.entity;

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
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 60, min = 1)
    @NotBlank
    @Column(name = "description", length = 60, nullable = false)
    private String description;

    //Relationships
    @JsonIgnore
    @OneToOne
    private Detail detail;

    public Notification(int i, String s){
    }
    public Notification(){
    }
}
