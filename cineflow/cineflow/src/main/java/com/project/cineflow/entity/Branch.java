package com.project.cineflow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="branch_id")
    private int id;

    @Column(name="branch_name")
    private String branchName;

    @Column(name="location")
    private String location;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<Movie> movie;

}
