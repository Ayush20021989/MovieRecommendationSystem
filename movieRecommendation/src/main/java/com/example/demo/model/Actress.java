package com.example.demo.model;

import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "Actresses")
public class Actress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Actress name cannot be blank")
    @Column(name = "Actress_Name")
    private String name;

}
