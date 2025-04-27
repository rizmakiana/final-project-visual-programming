package com.unindra.service;

import com.unindra.model.request.TeacherRequest;
import com.unindra.repository.TeacherRepository;
import com.unindra.validation.TeacherValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeacherServiceImpl implements TeacherService{

    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void addData(TeacherRequest request) {

        String errorMessage = TeacherValidator.validate(request);

        if (errorMessage != null) {
            throw new IllegalArgumentException(errorMessage);
        }
        
        teacherRepository.add(request);

        log.info("successfully add data");
    }

    @Override
    public TeacherRequest[] getAllData() {
        TeacherRequest[] all = teacherRepository.getAll();

        return all;
    }

    @Override
    public void update(String id, TeacherRequest request) {
        
        String errorMessage = TeacherValidator.validate(request);

        if (errorMessage != null) {
            throw new IllegalArgumentException(errorMessage);
        }

        teacherRepository.update(id, request);

        log.info("succes update data");


    }
    
}
