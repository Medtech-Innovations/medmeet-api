package org.medtech.medmeet.support.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResource {

    private Integer id;
    private String firstName;
    private String question_text;
}
