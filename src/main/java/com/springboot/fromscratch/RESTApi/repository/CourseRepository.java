// respository layer which is used for sql or database connectivity

package com.springboot.fromscratch.RESTApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.fromscratch.RESTApi.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>{


}
