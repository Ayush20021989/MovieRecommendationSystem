package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Actress;
import com.example.demo.repository.ActressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ActressService {

    private final ActressRepository actressRepository;

    @Autowired
    public ActressService(ActressRepository actressRepository) {
        this.actressRepository = actressRepository;
    }

    public List<Actress> getAllActresses() {
        return actressRepository.findAll();
    }

    public Actress createActress(@Valid Actress actress) {
        return actressRepository.save(actress);
    }

    public Actress getActressById(long id) throws ResourceNotFoundException {
        return actressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actress not found with id: " + id));
    }

    public Actress updateActress(long id, @Valid Actress actress) throws ResourceNotFoundException {
        Actress existingActress = actressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actress not found with id: " + id));

        existingActress.setName(actress.getName());


        return actressRepository.save(existingActress);
    }

    public void deleteActress(long id) throws ResourceNotFoundException {
        Actress actress = actressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actress not found with id: " + id));

        actressRepository.delete(actress);
    }

}
