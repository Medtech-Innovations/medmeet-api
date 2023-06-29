package org.medtech.medmeet.contact.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DetailResource {
    private Integer id;
    private Date detailDate;
}
