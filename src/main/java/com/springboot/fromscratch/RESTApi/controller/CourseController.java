/*
 
MySQL DB -> fromscratchrestapi
MySQL Table -> course_entity  -------- for future references (or make a new one using @Table(name = "course") annotation in entity class)
 
 
 It does the following tasks:
 1. it has the instances for the service interfaces
 2. Calls the methods of GET ALL, GET BY ID, ADD, UPDATE, DELETE 
 3. Returns the desired outputs
 
*/



package com.springboot.fromscratch.RESTApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.fromscratch.RESTApi.entity.CourseEntity;
import com.springboot.fromscratch.RESTApi.service.CourseService;

@RestController        // to indicate the controller layer
public class CourseController {
	
	
	/*
 	service layer instance in controller is defined so that we can connect both these layers for accessing the functions 
	defined in the service layer from the controller: Autowired is used in this regards for ensuring the dependency injection
	in loosely coupled manner
	 */
	
	@Autowired          
	private CourseService courseService;


	List<CourseEntity> coursesList;
	
	
	// get all method
	@GetMapping("/course")
	public List<CourseEntity> getAll(){
		return courseService.getAll();
	}
	
	// get by id method
	@GetMapping("/course/{courseId}")
	public CourseEntity getOneCourse(@PathVariable String courseId){
		return courseService.getOneCourse(Integer.parseInt(courseId));
	}
	
	// adding the course 
	@PostMapping("/course")
	public CourseEntity addCourse(@RequestBody CourseEntity course) {
		return courseService.addCourse(course);
	}
	
	// updating the course
	@PutMapping("/course")
	public CourseEntity updateCourse(@RequestBody CourseEntity course) {
		return courseService.updateCourse(course);
	}
	
	// deleted the particular course
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseService.deleteCourse(Integer.parseInt(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/*
	 requestParam - its the one taken in the string format like courseId, - to ensure its working, we parse it into INT
	 requestBody - used in the POST, PUT method - the one we write in body,raw,json format
	 */
	
	

}
