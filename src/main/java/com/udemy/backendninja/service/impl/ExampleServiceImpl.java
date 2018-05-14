package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService") // se genera un bean que va a iniciar en el arranque del servidor
public class ExampleServiceImpl implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleService.class);
	
	
	@Override // service va la logica de la aplicacion el controller solo llama al servicio
	public List<Person> getListPeople() {
			List<Person> people = new ArrayList<>();
			people.add(new Person("thony", 23));
			people.add(new Person("asd", 23));
			people.add(new Person("qwe", 23));
			people.add(new Person("zxc", 23));
			people.add(new Person("adw", 23));
			LOG.info("HELLO FROM SERVICE");
			return people;
	}

}
