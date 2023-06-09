package org.medtech.medmeet.contact.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.medtech.medmeet.contact.domain.model.entity.Detail;
import org.medtech.medmeet.contact.domain.persistance.DetailRepository;
import org.medtech.medmeet.contact.domain.service.DetailService;
import org.medtech.medmeet.shared.exception.ResourceNotFoundException;
import org.medtech.medmeet.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DetailServiceImpl implements DetailService {
    private static final String ENTITY = "Detail";

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private Validator validator;

    public DetailServiceImpl(DetailRepository _detailRepository, Validator _validator) {
        this.detailRepository = _detailRepository;
        this.validator = _validator;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Detail> fetchAll() { return detailRepository.findAll(); }

    @Override
    public Detail fetchByID(Integer id) {
        return null;
    }

   //@Transactional(readOnly = true)
   //@Override
   //public Detail fetchById(Integer id) {
   //    return detailRepository.findById(id)
   //            .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
   //}

    @Override
    public Detail save(Detail detail) {
        Set<ConstraintViolation<Detail>> violations = validator.validate(detail);
        if(!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return detailRepository.save(detail); }

    @Override
    public Detail update(Detail detail) {
        Set<ConstraintViolation<Detail>> violations = validator.validate(detail);
        if (!violations.isEmpty()) {
            throw new ResourceValidationException(ENTITY, violations);
        }

        return detailRepository
                .findById(detail.getId())
                .map(detailToUpdate -> {
                    detailToUpdate.setDetailDate(detail.getDetailDate());

                    return detailRepository.save(detailToUpdate);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, detail.getId()));
    }

    @Override
    public boolean deleteById(Integer id) {
//        if (detailRepository.existsById(id)) {
//            detailRepository.deleteById(id);
//        }
        var detailToDelete = detailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
        detailRepository.delete(detailToDelete);
        return true;
    }
}
