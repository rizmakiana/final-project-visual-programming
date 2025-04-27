package com.unindra.service;

import com.unindra.model.request.TeacherRequest;

public interface TeacherService {
    
    void addData(TeacherRequest request);

    TeacherRequest[] getAllData();

    void update(String id, TeacherRequest request);
}
