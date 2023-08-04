/*
 
 It's also called as the business layer logic layer
 
 It does the following tasks:
 1. it implements service interface
 2. instance of repository layer - autowired annotation
 3. Body of the CRUD method's operation
 
 
*/


package com.springboot.fromscratch.RESTApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.fromscratch.RESTApi.entity.CourseEntity;
import com.springboot.fromscratch.RESTApi.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	

	/* 
	 autowired has eliminated the need of defining the class which will implement the repository interface and then defining the
	 instance for that class, autowired does that task internally
	 
	 
	By using @Autowired in the constructor of CourseService, you are telling Spring to look for a bean that 
	 implements the CourseRepository interface and automatically inject it into the CourseService class. 
	 You don't need to manually create an instance of the implementation class for the repository or provide 
	 any explicit configuration. Spring takes care of handling the instantiation and injection of the required 
	 beans based on the annotations and the configuration of the application context.
	 
	 */
	
	@Autowired
	private CourseRepository courseRepository;
	
	List<CourseEntity> courseList;
	
	
	// get method
	@Override
	public List<CourseEntity> getAll(){
		return courseRepository.findAll();
	}

	
	
	
	/*
	 
	 findById method returns the Optional<CourseEntity>, so return the noraml CourseEntity from this,
	 we have used he if statement, it will set it to null if Optional<CourseEntity> is not present and if it's there,
	 it will set it to the CourseEntity course instance
	 
	 */
	@Override
	public CourseEntity getOneCourse(int id) {
		Optional<CourseEntity> entity = courseRepository.findById(id);
		CourseEntity course = null;
		if (entity.isPresent()) {
		    course = entity.get();
		}
		return course;
	}

	
	
	/*	 
	 courseRepository.save(course) 
	 .save function has two things to do:
	 1. POST - if there is no object like the course already present, it will post
	 2. PUT - if there is one with the same id, then it will update the one.	 
	 */
	@Override
	public CourseEntity addCourse(CourseEntity course) {
		return courseRepository.save(course);
	}

	
	// put method
	@Override
	public CourseEntity updateCourse(CourseEntity course) {
		return courseRepository.save(course);
	}

	
	// delete method
	@Override
	public void deleteCourse(int id) {
		Optional<CourseEntity> entity = courseRepository.findById(id);
		CourseEntity course = null;
		if (entity.isPresent()) {
		    course = entity.get();
		}
		courseRepository.delete(course);
	}

}
