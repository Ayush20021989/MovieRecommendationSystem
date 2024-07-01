package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.leadActor.name = :actorName")
    List<Movie> findMoviesByActorName(@Param("actorName") String actorName);

    @Query("SELECT m FROM Movie m WHERE m.leadActress.name = :actressName")
    List<Movie> findMoviesByActressName(@Param("actressName") String actressName);
}
