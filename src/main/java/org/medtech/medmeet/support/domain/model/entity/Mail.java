package org.medtech.medmeet.support.domain.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;

@Getter
@Setter
@Table(name = "mails")
@Entity
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sender_id")
    private Integer senderId;

    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date dates;

    @Size(min = 3, max = 80)
    @Column(name = "message", nullable = false, columnDefinition = "TEXT")
    private String message;

    @OneToMany(mappedBy = "mails")
    private ArrayList<Consultation> inquiries;

}
