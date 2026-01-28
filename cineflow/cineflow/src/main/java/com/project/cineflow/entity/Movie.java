package com.project.cineflow.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private int id;

    @Column(name="movie_name")
    private String movieName;

    @Column(name="description")
    private String description;

    @Column(name="poster")
    private String poster;

}
