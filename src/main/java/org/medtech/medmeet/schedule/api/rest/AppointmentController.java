package org.medtech.medmeet.schedule.api.rest;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.schedule.domain.model.entity.Appointment;
import org.medtech.medmeet.schedule.domain.service.AppointmentService;
import org.medtech.medmeet.schedule.mapping.AppointmentMapper;
import org.medtech.medmeet.schedule.resource.AppointmentResource;
import org.medtech.medmeet.schedule.resource.CreateAppointmentResource;
import org.medtech.medmeet.schedule.resource.UpdateAppointmentResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointments")
@AllArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final AppointmentMapper mapper;

    @GetMapping
    public List<Appointment> fetchAll() {
        return appointmentService.fetchAll();
    }

    @GetMapping("{id}")
    public AppointmentResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(appointmentService.fetchById(id));
    }

    @PostMapping
    public AppointmentResource save(@RequestBody CreateAppointmentResource resource) {
        return mapper.toResource( appointmentService.save(mapper.toModel(resource)));
    }


    @PutMapping("{id}")
    public ResponseEntity<AppointmentResource>update(@PathVariable Integer id,
                                                     @RequestBody UpdateAppointmentResource resource) {
        if (id.equals(resource.getId())) {
            AppointmentResource appointmentResource = mapper.toResource(
                    appointmentService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(appointmentResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (appointmentService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
