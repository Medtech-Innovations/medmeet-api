package org.medtech.medmeet.contact.domain.service;

import org.medtech.medmeet.contact.domain.model.entity.Detail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DetailService {
    List<Detail>fetchAll();
    Detail fetchByID(Integer id);

//    @Transactional(readOnly = true)
//    Detail fetchById(Integer id);

    Detail save(Detail detail);
    Detail update(Detail detail);
    boolean deleteById(Integer id);
}
