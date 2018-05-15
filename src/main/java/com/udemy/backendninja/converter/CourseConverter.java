package com.udemy.backendninja.converter;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;

@Component("curseConverter")
public class CourseConverter {
	
	// converter Entity -- a un model
	
	public CourseModel entity2Model(Course course) {
		CourseModel cm = new CourseModel();
		cm.setName(course.getName());
		cm.setDescription(course.getDescription());
		cm.setPrice(course.getPrice());
		cm.setHours(course.getHours());
		return cm;
	}
	
	// model -- entity
	
	public Course model2Entity(CourseModel courseModel) {
		Course mc = new Course();
		mc.setName(courseModel.getName());
		mc.setDescription(courseModel.getDescription());
		mc.setPrice(courseModel.getPrice());
		mc.setHours(courseModel.getHours());
		return mc;
	}
}
