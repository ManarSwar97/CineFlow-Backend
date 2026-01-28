package com.project.cineflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private int id;

    @Column(name="movie_name")
    private String movieName;

    @Column(name="description")
    private String description;

    @Column(name="poster")
    private String poster;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Showtime> showtimeList;

    @ManyToOne
    @JoinColumn(name="branch_id")
    private Branch branch;

    @ManyToOne
    @JoinColumn(name="admin_id")
    private Admin admin;

}
