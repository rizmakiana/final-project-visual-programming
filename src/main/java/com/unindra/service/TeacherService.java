package com.unindra.service;

import java.time.LocalDate;
import java.util.Date;

import com.unindra.model.request.TeacherRequest;

public interface TeacherService {
    
    void addData(TeacherRequest request);

    TeacherRequest[] getAllData();

    void update(String id, TeacherRequest request);

    void delete(String id);

    LocalDate toLocalDate(Date date);
}
