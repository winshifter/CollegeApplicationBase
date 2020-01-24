package com.college.app.service;

import java.util.Collection;

import com.college.app.model.Student;

public interface StudentService {
	Collection<Student> find();
	Student load(Long id);
	Student persist(Student student);
	Student merge(Student student);
	void delete(Long id);
}
