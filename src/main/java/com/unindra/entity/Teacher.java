package com.unindra.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private String name;

    private String id;

    private String birthPlace;

    private LocalDate birthDate;

    private String gender;

    private String address;

    private String phoneNumber;

    private String email;
    
}