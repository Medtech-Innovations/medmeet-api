package org.medtech.medmeet.contact.repository;

import org.medtech.medmeet.contact.domain.model.entity.Notification;
import org.medtech.medmeet.contact.util.NotificationValidator;

public class NotificationRepositoryImpl implements NotificationRepository{
    @Override
    public Notification findById(Integer id) {
        NotificationValidator.validateNotificationId(id);
        return new Notification(1, "Text");
    }

}
