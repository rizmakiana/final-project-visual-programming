package com.unindra.model.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherRequest {

    private String name;

    private String id;

    private String birthPlace;

    private Date birthDate;

    private String gender;

    private String address;

    private String phoneNumber;

    private String email;
    
}