package org.medtech.medmeet.contact.domain.service;

import org.medtech.medmeet.contact.domain.model.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> fetchAll();
    Notification fetchById(Integer id);
    Notification save(Notification notification);
    Notification update(Notification notification);
    boolean deleteById(Integer id);
}
