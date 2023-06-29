package org.medtech.medmeet.support.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.medtech.medmeet.schedule.resource.appointment.AppointmentResource;
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

@Tag(name = "Questions", description = "Create, Read, Update ande delete questions entities")
@RestController
@RequestMapping("api/v1/questions")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper mapper;

    @Operation(summary = "Save a question", responses = {
            @ApiResponse(description = "Question successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @PostMapping
    public QuestionResource save(@RequestBody CreateQuestionResource resource){
        return mapper.toResource(questionService.save(mapper.toModel(resource)));
    }

    @Operation(summary = "Get all registered questions", responses = {
            @ApiResponse(description = "Successfully fetched all questions",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping
    public List<Question> fetchAll(){
        return questionService.fetchAll();
    }

    @Operation(summary = "Get a question by id", responses = {
            @ApiResponse(description = "Successfully fetched question by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @GetMapping("{id}")
    public QuestionResource fetchId(@PathVariable Integer id){
        return this.mapper.toResource(questionService.fetchById(id).get());
    }

    @Operation(summary = "Update a question by id", responses = {
            @ApiResponse(description = "Successfully updated question by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
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

    @Operation(summary = "Delete a question by id", responses = {
            @ApiResponse(description = "Successfully deleted question by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AppointmentResource.class)))
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (questionService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
