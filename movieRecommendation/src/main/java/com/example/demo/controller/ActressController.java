package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Actress;
import com.example.demo.service.ActressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actresses")
public class ActressController {

    @Autowired
    private ActressService actressService;

    @GetMapping
    public List<Actress> getAllActresses() {
        return actressService.getAllActresses();
    }

    @PostMapping
    public Actress createActress(@RequestBody Actress actress) {
        return actressService.createActress(actress);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actress> getActressById(@PathVariable long id) {
        try {
            Actress actress = actressService.getActressById(id);
            return ResponseEntity.ok(actress);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actress> updateActress(@PathVariable long id, @RequestBody Actress actressDetails) {
        try {
            Actress updatedActress = actressService.updateActress(id, actressDetails);
            return ResponseEntity.ok(updatedActress);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteActress(@PathVariable long id) {
        try {
            actressService.deleteActress(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
