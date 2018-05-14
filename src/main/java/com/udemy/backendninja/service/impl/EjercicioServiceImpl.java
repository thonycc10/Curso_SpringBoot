package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.EjercicioService;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService{

	private static final Log LOG = LogFactory.getLog(EjercicioService.class);
	
	@Override
	public List<Person> findAll() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Thony", 23));
		people.add(new Person("Paula", 21));
		people.add(new Person("Cristian", 17));
		
		LOG.info("HOLA SOY DE EJERCICIO");
		return people; // recuerda que para el each tiene que tener el mismo nombre th:each="person : ${people}"
	}

}
