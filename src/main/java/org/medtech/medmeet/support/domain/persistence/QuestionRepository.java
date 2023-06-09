package org.medtech.medmeet.support.domain.persistence;

import org.medtech.medmeet.support.domain.model.entity.Category;
import org.medtech.medmeet.support.domain.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{

    //Obtener todas las preguntas con una categoria especifica
    List<Question> findByCategory(Category category);

    @Query("SELECT quer FROM Question quer where quer.question_text =:question_text or quer.category.name =:category")
    List<Question> fetchByQuestion_textOrCategory(@Param("question_text")String question_text,@Param("category")String category);

}
