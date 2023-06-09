package org.medtech.medmeet.support.api;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.support.domain.model.entity.Question;
import org.medtech.medmeet.support.domain.service.QuestionService;
import org.medtech.medmeet.support.mapping.QuestionMapper;
import org.medtech.medmeet.support.resource.CreateQuestionResource;
import org.medtech.medmeet.support.resource.QuestionResource;
import org.medtech.medmeet.support.resource.UpdateQuestionResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper mapper;

    @PostMapping
    public QuestionResource save(@RequestBody CreateQuestionResource resource){
        return mapper.toResource(questionService.save(mapper.toModel(resource)));
    }

    @GetMapping
    public List<Question> fetchAll(){
        return questionService.fetchAll();
    }

    @GetMapping("{id}")
    public QuestionResource fetchId(@PathVariable Integer id){
        return this.mapper.toResource(questionService.fetchById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<QuestionResource> update(@PathVariable Integer id,
                                                   @RequestBody UpdateQuestionResource resource){
        if(id.equals(resource.getId())) {
            QuestionResource questionResource = mapper.toResource(
                    questionService.update( mapper.toModel(resource) ) );
                    return new ResponseEntity<>(questionResource, HttpStatus.OK);
            } else {
                return ResponseEntity.badRequest().build();
            }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (questionService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
