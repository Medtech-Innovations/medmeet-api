package org.medtech.medmeet.contact.repository;

import org.medtech.medmeet.contact.domain.model.entity.Notification;

public interface NotificationRepository {
    Notification findById(Integer id);
}
