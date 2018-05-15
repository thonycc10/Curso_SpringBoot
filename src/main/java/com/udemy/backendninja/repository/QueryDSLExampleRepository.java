package com.udemy.backendninja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.QCourse;

@Repository("queryDSLExampleRepository")
public class QueryDSLExampleRepository {
	// uso cmd mvn eclipse:eclipse para relacionar 
	private QCourse qCourse = QCourse.course;
	
	// obtener em
	@PersistenceContext
	private EntityManager em;
	
	public Course find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<>(em); // entity manager encargado de la persistencia de la aplicacion
		
		BooleanBuilder bb = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		
		if(exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			bb.and(predicate2);
		}else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			bb.or(predicate3);
		}
		
		return query.select(qCourse).from(qCourse).where(bb).fetchOne();
		
//		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();
	}
}
