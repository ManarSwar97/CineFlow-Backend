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
public class Branch {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="branch_id")
    private int id;

    @Column(name="branch_name")
    private String branchName;

    @Column(name="location")
    private String location;

}
