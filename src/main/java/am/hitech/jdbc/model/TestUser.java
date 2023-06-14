package am.hitech.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TestUser {
    private String name;
    private String surName;
    private int age;
    private String email;

}
