package com.project.cineflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="showtime_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="movie_id")
    private Movie movie;

    @Column(name="capacity")
    private int capacity;

    @Column(name="booked_count")
    private int bookedCount;

    @Column(name="price")
    private int price;

}
