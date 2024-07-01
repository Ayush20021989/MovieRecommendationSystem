package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Movie title cannot be blank")
    @Column(name = "Movie_Title")
    private String title;

    @NotBlank(message = "Director name cannot be blank")
    @Column(name = "Movie_Director")
    private String director;

    @PositiveOrZero(message = "Release year must be a non-negative value")
    @Column(name = "Movie_Year")
    private int year;

    @NotBlank(message = "Genre cannot be blank")
    @Column(name = "Movie_Genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "lead_actor_id")
    private Actor leadActor;

    @ManyToOne
    @JoinColumn(name = "lead_actress_id")
    private Actress leadActress;
}
