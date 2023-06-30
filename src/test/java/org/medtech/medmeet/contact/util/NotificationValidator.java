package org.medtech.medmeet.contact.util;

public class NotificationValidator {
    public static boolean validateNotificationId(Integer id){
        if (id == null ){
            throw new NullPointerException("Is Null");
        } else if (id <= 0) {
            throw new IllegalArgumentException("No hay Id");
        }
        return true;
    }
}
