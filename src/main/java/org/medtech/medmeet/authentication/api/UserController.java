package org.medtech.medmeet.authentication.api;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.authentication.domain.model.entity.User;
import org.medtech.medmeet.authentication.domain.service.UserService;
import org.medtech.medmeet.authentication.mapping.UserMapper;
import org.medtech.medmeet.authentication.resource.CreateUserResource;
import org.medtech.medmeet.authentication.resource.UpdateUserResource;
import org.medtech.medmeet.authentication.resource.UserResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    @PostMapping
    public UserResource save(@RequestBody CreateUserResource resource) {
        return mapper.toResource( userService.save( mapper.toModel(resource) ) );
    }

    @GetMapping
    public List<User> fetchAll() {
        return userService.fetchAll();
    }

    @GetMapping("{id}")
    public UserResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(userService.fetchById(id).get());
    }

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

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (userService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
