package org.medtech.medmeet.authentication.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.medtech.medmeet.authentication.domain.model.entity.User;
import org.medtech.medmeet.authentication.domain.service.UserService;
import org.medtech.medmeet.authentication.mapping.UserMapper;
import org.medtech.medmeet.authentication.resource.CreateUserResource;
import org.medtech.medmeet.authentication.resource.UpdateUserResource;
import org.medtech.medmeet.authentication.resource.UserResource;
import org.medtech.medmeet.schedule.resource.appointment.AppointmentResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users", description = "Create, Read, Update ande delete users entities")
@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @Operation(summary = "Get all registered users", responses = {
            @ApiResponse(description = "Successfully fetched all users",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class)))
    })
    @GetMapping
    public List<User> fetchAll() {
        return userService.fetchAll();
    }

    @Operation(summary = "Get an user by id", responses = {
            @ApiResponse(description = "Successfully fetched user by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class)))
    })
    @GetMapping("{id}")
    public UserResource fetchById(@PathVariable Integer id) {
        return this.mapper.toResource(userService.fetchById(id).get());
    }

    @Operation(summary = "Save an user", responses = {
            @ApiResponse(description = "User successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class)))
    })
    @PostMapping
    public UserResource save(@RequestBody CreateUserResource resource) {
        return mapper.toResource( userService.save( mapper.toModel(resource) ) );
    }

    @Operation(summary = "Update an user by id", responses = {
            @ApiResponse(description = "Successfully updated user by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class)))
    })
    @PutMapping("{id}")
    public ResponseEntity<UserResource> update(@PathVariable Integer id, @RequestBody UpdateUserResource resource) {
        if (id.equals(resource.getId())) {
            UserResource userResource = mapper.toResource(
                    userService.update( mapper.toModel(resource) ) );
            return new ResponseEntity<>(userResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Delete a user by id", responses = {
            @ApiResponse(description = "Successfully deleted user by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResource.class)))
    })
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (userService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
