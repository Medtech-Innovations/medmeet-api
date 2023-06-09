package org.medtech.medmeet.contact.api.rest;

import lombok.AllArgsConstructor;
import org.medtech.medmeet.contact.domain.model.entity.Detail;
import org.medtech.medmeet.contact.domain.service.DetailService;
import org.medtech.medmeet.contact.mapping.DetailMapper;
import org.medtech.medmeet.contact.resource.CreateDetailResource;
import org.medtech.medmeet.contact.resource.DetailResource;
import org.medtech.medmeet.contact.resource.UpdateDetailResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("details")
@AllArgsConstructor
public class DetailController {
    private final DetailService detailService;
    private final DetailMapper mapper;

    @GetMapping
    public List<Detail> fetchAll(){
        return detailService.fetchAll();
    }

    @GetMapping({"{id}"})
    public  DetailResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(detailService.fetchByID(id));
    }

    @PostMapping
    public DetailResource save(@RequestBody CreateDetailResource resource){
        return mapper.toResource( detailService.save(mapper.toModel(resource)));
    }

    @PutMapping("{id}")
    public ResponseEntity<DetailResource>update(@PathVariable Integer id,
                                                @RequestBody UpdateDetailResource resource){
        if(id.equals(resource.getId())){
            DetailResource detailResource = mapper.toResource(
                    detailService.update(mapper.toModel(resource)));
            return new ResponseEntity<>(detailResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (detailService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
