package org.medtech.medmeet.support.util;

public class QuestionValidator {

    public static boolean validateQuestionId(Integer id){
        if (id== null){
            throw new NullPointerException("Is Null");
        } else if (id <= 0) {
            throw new IllegalArgumentException("No hay Id");
        }
        return true;
    }
}
