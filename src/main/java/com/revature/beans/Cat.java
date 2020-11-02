package com.revature.beans;

import java.io.Serializable;

import com.revature.util.Roster;

public class Cat implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private double weight;
	private int age;
	private String color;
	private String breed;
	
	public Cat() {
		super();
		Roster.catList.add(this);
	}
	
	public Cat(String name, double weight, int age, String color, String breed) {
		super();
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.color = color;
		this.breed = breed;
		Roster.catList.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", weight=" + weight + ", age=" + age + ", color=" + color + ", breed=" + breed
				+ "]";
	}
	
	
	
}
