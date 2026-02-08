package com.project.cineflow.enums;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//enums is used when we have a fixed set of known values
@NoArgsConstructor
public enum UserRole {

    //the allowed values of UserRole enums
    //they are like an object
    ADMIN("admin"),
    USER("user");

    //used to store enums value: admin, user
    private String role;

    UserRole(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }
}
