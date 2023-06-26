package org.medtech.medmeet.schedule.api.rest;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.schedule.domain.model.entity.Patient;
import org.medtech.medmeet.schedule.domain.service.PatientService;
import org.medtech.medmeet.schedule.mapping.PatientMapper;
import org.medtech.medmeet.schedule.resource.doctor.CreateDoctorResource;
import org.medtech.medmeet.schedule.resource.doctor.DoctorResource;
import org.medtech.medmeet.schedule.resource.doctor.UpdateDoctorResource;
import org.medtech.medmeet.schedule.resource.patient.CreatePatientResource;
import org.medtech.medmeet.schedule.resource.patient.PatientResource;
import org.medtech.medmeet.schedule.resource.patient.UpdatePatientResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patients")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final PatientMapper mapper;

    @GetMapping
    public List<Patient> fetchAll() {
        return patientService.fetchAll();
    }

    @GetMapping("{id}")
    public PatientResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(patientService.fetchById(id).get());
    }

    @PostMapping
    public PatientResource save(@RequestBody CreatePatientResource resource) {
        return mapper.toResource(patientService.save(mapper.toModel(resource)));
    }

    @PutMapping("{id}")
    public ResponseEntity<PatientResource> update(@PathVariable Integer id,
                                                 @RequestBody UpdatePatientResource resource) {
        if (id.equals(resource.getId())) {
            PatientResource patientResource = mapper.toResource(
                    patientService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(patientResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (patientService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
