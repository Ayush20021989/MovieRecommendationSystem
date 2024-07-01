package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable long id) {
        try {
            Movie movie = movieService.getMovieById(id);
            return ResponseEntity.ok(movie);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movieDetails) {
        try {
            Movie updatedMovie = movieService.updateMovie(id, movieDetails);
            return ResponseEntity.ok(updatedMovie);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMovie(@PathVariable long id) {
        try {
            movieService.deleteMovie(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{movieId}/assignLeadActor/{actorId}")
    public ResponseEntity<Movie> assignLeadActor(@PathVariable long movieId, @PathVariable long actorId) {
        try {
            Movie updatedMovie = movieService.assignLeadActor(movieId, actorId);
            return ResponseEntity.ok(updatedMovie);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{movieId}/assignLeadActress/{actressId}")
    public ResponseEntity<Movie> assignLeadActress(@PathVariable long movieId, @PathVariable long actressId) {
        try {
            Movie updatedMovie = movieService.assignLeadActress(movieId, actressId);
            return ResponseEntity.ok(updatedMovie);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-actor/{actorName}")
    public ResponseEntity<List<Movie>> getMoviesByActorName(@PathVariable String actorName) {
        List<Movie> movies = movieService.getMoviesByActorName(actorName);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/by-actress/{actressName}")
    public ResponseEntity<List<Movie>> getMoviesByActressName(@PathVariable String actressName) {
        List<Movie> movies = movieService.getMoviesByActressName(actressName);
        return ResponseEntity.ok(movies);
    }
}
