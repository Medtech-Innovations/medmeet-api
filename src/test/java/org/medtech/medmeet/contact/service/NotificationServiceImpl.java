package org.medtech.medmeet.contact.service;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.contact.domain.model.entity.Notification;
import org.medtech.medmeet.contact.repository.NotificationRepository;

@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService{
    private final NotificationRepository notificationRepository;
    @Override
    public Notification buscarporId(Integer id){
        Notification notification = notificationRepository.findById(id);
        if(notification.getId()<20){
            notification.setId(notification.getId()*2);
        } else {
            notification.setId(notification.getId()*5);
        }
        return  notification;
    }
}
