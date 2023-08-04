package com.springboot.fromscratch.RESTApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CourseEntity {
	
	@Id
	private Integer id;
	private String courseName;
	private Double coursePrice;
	private String courseDesc;
	
	public CourseEntity() {
		
	}
	
	public CourseEntity(Integer id, String courseName, Double coursePrice, String courseDesc) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseDesc = courseDesc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Double getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(Double coursePrice) {
		this.coursePrice = coursePrice;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	
	
	
	

}
