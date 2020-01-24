package com.college.app.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.app.dao.StudentDao;
import com.college.app.model.Student;
import com.college.app.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	private Map<Long, Student> db = new HashMap<>();
	private static long count = 1;
	
	@Autowired
	private StudentDao dao;
	
	@Override
	public Collection<Student> find() {
		return dao.find();
	}

	@Override
	public Student load(Long id) {
		return dao.load(id);
	}

	@Override
	public Student persist(Student student) {
		if(student.getId() != null) {
			return merge(student);
		}
		return dao.persist(student);
	}

	@Override
	public Student merge(Student student) {
		return dao.merge(student);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

}
