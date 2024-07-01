package com.example.demo;

import com.example.demo.model.Actor;
import com.example.demo.model.Actress;
import com.example.demo.model.Movie;
import com.example.demo.repository.ActorRepository;
import com.example.demo.repository.ActressRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommendationSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommendationSystemApplication.class, args);
	}

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private ActressRepository actressRepository;

	@Override
	public void run(String... args) throws Exception {
	// Initialize Actors
		Actor actor1 = new Actor();
		actor1.setName("Tom Hanks");
		actorRepository.save(actor1);

		Actor actor2 = new Actor();
		actor2.setName("Brad Pitt");
		actorRepository.save(actor2);

		// Initialize Actresses
		Actress actress1 = new Actress();
		actress1.setName("Emma Stone");
		actressRepository.save(actress1);

		Actress actress2 = new Actress();
		actress2.setName("Scarlett Johansson");
		actressRepository.save(actress2);

		// Initialize Movies
		Movie movie1 = new Movie();
		movie1.setTitle("Inception");
		movie1.setDirector("Christopher Nolan");
		movie1.setYear(2010);
		movie1.setGenre("Sci-Fi");
		movie1.setLeadActor(actor1);
		movie1.setLeadActress(actress1);
		movieRepository.save(movie1);

		Movie movie2 = new Movie();
		movie2.setTitle("The Godfather");
		movie2.setDirector("Francis Ford Coppola");
		movie2.setYear(1972);
		movie2.setGenre("Crime");
		movie2.setLeadActor(actor2);
		movie2.setLeadActress(actress2);
		movieRepository.save(movie2);
	}
}
