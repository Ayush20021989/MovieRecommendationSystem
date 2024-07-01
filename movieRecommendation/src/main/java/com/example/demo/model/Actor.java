package com.example.demo.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Actor name cannot be blank")
    @Column(name = "Actor_Name")
    private String name;

}
