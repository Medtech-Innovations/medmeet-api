package org.medtech.medmeet.schedule.api.rest;

import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.medtech.medmeet.schedule.domain.model.entity.Doctor;
import org.medtech.medmeet.schedule.domain.persistence.SpecialtyRepository;
import org.medtech.medmeet.schedule.domain.service.DoctorService;
import org.medtech.medmeet.schedule.mapping.DoctorMapper;
import org.medtech.medmeet.schedule.resource.doctor.CreateDoctorResource;
import org.medtech.medmeet.schedule.resource.doctor.DoctorResource;
import org.medtech.medmeet.schedule.resource.doctor.UpdateDoctorResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctors")
@AllArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
    private final SpecialtyRepository specialtyRepository;
    private Validator validator;
    private final DoctorMapper mapper;

    @GetMapping
    public List<Doctor> fetchAll() {
        return doctorService.fetchAll();
    }

    @GetMapping("{id}")
    public DoctorResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(doctorService.fetchById(id).get());
    }

    @PostMapping
    public DoctorResource save(@RequestBody CreateDoctorResource resource) {
        return mapper.toResource(doctorService.save(mapper.toModel(resource), resource.getAssignedSpecialtyId()));
    }

    @PutMapping("{id}")
    public ResponseEntity<DoctorResource> update(@PathVariable Integer id,
                                                    @RequestBody UpdateDoctorResource resource) {
        if (id.equals(resource.getId())) {
            DoctorResource doctorResource = mapper.toResource(
                    doctorService.updateSpecialty(mapper.toModel(resource), resource.getSpecialtyId()));
            return new ResponseEntity<>(doctorResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (doctorService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
