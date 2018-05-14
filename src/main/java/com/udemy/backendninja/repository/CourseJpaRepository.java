package com.udemy.backendninja.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backendninja.entity.Course;

@Repository("courseJpaRepository") // nos vamos a component example
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {

	// ejemplos de query usando el mismo metodo ojo el final cambia de acuerdo a tu entity
	public abstract Course findByPrice(int price);
	
	public abstract Course findByPriceAndName(int price, String name);
	
	public abstract List<Course> findByNameOrderByHours(String Name);
	
	public abstract Course findByNameOrPrice(String name, int price);
}
