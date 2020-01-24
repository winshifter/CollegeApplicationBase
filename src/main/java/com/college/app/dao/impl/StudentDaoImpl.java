package com.college.app.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.college.app.dao.StudentDao;
import com.college.app.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Collection<Student> find() {
		Query query = entityManager.createQuery("SELECT s FROM Student s");
	    return (Collection<Student>) query.getResultList();
	}

	@Override
	public Student load(Long id) {
		return entityManager.find(Student.class, id);
	}

	@Override
	public Student persist(Student student) {
		entityManager.persist(student);
		return student;
	}

	@Override
	public Student merge(Student student) {
		entityManager.merge(student);
		return student;
	}

	@Override
	public void delete(Long id) {
		Student s = load(id);
		if(s != null) {
			entityManager.remove(s);
		}
	}

}
