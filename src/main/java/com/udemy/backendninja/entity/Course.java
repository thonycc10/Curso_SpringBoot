package com.udemy.backendninja.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue
	@Column(name="id")// indicamos la anotacion de basede datos
	private int id; // idCourse en hibernate id_course
	
	@Column(name="name")
	private String name;
	

	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;

	@Column(name="hours")
	private int hours;

	public Course() {
	}

	public Course(int id, String name, String description, int price, int hours) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

}
