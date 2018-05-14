package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Course;

public interface CourseService {
	// listado de cursos
	public abstract List<Course> listAllCourses();
	
	// Agregar 
	public abstract Course addCourse(Course course);
	
	// Eliminar
	public abstract int removeCourse(int id);
	
	// modificar
	public abstract Course updateCourse(Course course);
}
