package org.medtech.medmeet.authentication.util;

public class UserValidator {
    public static boolean validateUserId(Integer id){
        if (id== null){
            throw new NullPointerException("Is Null");
        } else if (id <= 0) {
            throw new IllegalArgumentException("No hay Id");
        }
        return true;
    }
}
