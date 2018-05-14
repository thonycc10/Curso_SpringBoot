package com.udemy.backendninja.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {

	@NotNull // no permite null example3
	@Size(min=2, max=6)
	private String name;
	
	@NotNull
	@Min(18) //ingresar valores
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	
}
