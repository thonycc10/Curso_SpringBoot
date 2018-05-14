package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;


@Controller
@RequestMapping("/example")
public class ExampleController {

	// recomendado utilizar
	public static final String EXAMPLE_VIEW = "example";
	
	// Inyectamos este component 
	@Autowired
	@Qualifier("exampleComponent") // nombre igual al componente llamado en el pack component
	private ExampleComponent exampleComponent;
	
	// primera forma
//	@RequestMapping(value = "/exampleString", method = RequestMethod.GET)
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	
	// segunda forma
//	@RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView andView= new ModelAndView(EXAMPLE_VIEW); // añdaes el nombre de la plantilla html
		andView.addObject("people",  getPeople());
//		return new ModelAndView(EXAMPLE_VIEW);
		return andView;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("thony", 23));
		people.add(new Person("asd", 23));
		people.add(new Person("qwe", 23));
		people.add(new Person("zxc", 23));
		people.add(new Person("adw", 23));
		return people;
	}
		
}
