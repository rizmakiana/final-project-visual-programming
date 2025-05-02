package com.unindra.repository;

import com.unindra.model.request.TeacherRequest;

public interface TeacherRepository {

	void add(TeacherRequest teacherRequest);

	TeacherRequest[] getAll();

	String findById(String id);

	void deleteAll();

	void update(String id, TeacherRequest request);

	void deleteById(String id);
		
}