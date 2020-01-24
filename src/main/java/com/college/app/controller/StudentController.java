package com.college.app.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.app.model.Student;
import com.college.app.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@RequestMapping(value = "/students", method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Student> loadStudents(){
		return service.find();
	}
	
	@RequestMapping(value = "/students/{id}", method=RequestMethod.GET, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Student loadStudent(@PathVariable Long id){
		return service.load(id);
	}
	
	@RequestMapping(value = "/students", method=RequestMethod.POST, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Student saveStudent(@RequestBody Student student){
		return service.persist(student);
	}
	
	@RequestMapping(value = "/students/{id}", method=RequestMethod.DELETE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public void deleteStudent(@PathVariable Long id, HttpServletResponse response){
		service.delete(id);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}

}
