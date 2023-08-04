package com.springboot.fromscratch.RESTApi.service;

import java.util.List;
import java.util.Optional;

import com.springboot.fromscratch.RESTApi.entity.CourseEntity;

public interface CourseService {

	public List<CourseEntity> getAll();
	public CourseEntity getOneCourse(int id);
	public CourseEntity addCourse(CourseEntity course);
	public CourseEntity updateCourse(CourseEntity course);
	public void deleteCourse(int id);
		
}
