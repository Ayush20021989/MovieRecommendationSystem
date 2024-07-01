package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Actor;
import com.example.demo.model.Actress;
import com.example.demo.model.Movie;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.ActressRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ActorRepository actorRepository;
    private final ActressRepository actressRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository, ActressRepository actressRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.actressRepository = actressRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie createMovie(@Valid Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(long id) throws ResourceNotFoundException {
        return movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
    }

    public Movie updateMovie(long id, @Valid Movie movie) throws ResourceNotFoundException {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setYear(movie.getYear());
        existingMovie.setGenre(movie.getGenre());

        return movieRepository.save(existingMovie);
    }

    public void deleteMovie(long id) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        movieRepository.delete(movie);
    }

    public Movie assignLeadActor(long movieId, long actorId) throws ResourceNotFoundException {
        Movie movie = getMovieById(movieId);
        Actor actor = actorRepository.findById(actorId)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not found with id: " + actorId));
        movie.setLeadActor(actor);
        return movieRepository.save(movie);
    }

    public Movie assignLeadActress(long movieId, long actressId) throws ResourceNotFoundException {
        Movie movie = getMovieById(movieId);
        Actress actress = actressRepository.findById(actressId)
                .orElseThrow(() -> new ResourceNotFoundException("Actress not found with id: " + actressId));
        movie.setLeadActress(actress);
        return movieRepository.save(movie);
    }

    public List<Movie> getMoviesByActorName(String actorName) {
        return movieRepository.findMoviesByActorName(actorName);
    }

    public List<Movie> getMoviesByActressName(String actressName) {
        return movieRepository.findMoviesByActressName(actressName);
    }
}
