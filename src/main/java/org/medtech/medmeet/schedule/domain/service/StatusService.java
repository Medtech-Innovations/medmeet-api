package org.medtech.medmeet.schedule.domain.service;


import org.medtech.medmeet.schedule.domain.model.entity.Status;

import java.util.List;

public interface StatusService {
    List<Status> fetchAll();
    Status fetchById(Integer id);
    Status save(Status status);
    Status update(Status status);
    boolean deleteById(Integer id);
}
