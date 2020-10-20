package com.revature;

public class Cat {
	private String name;
	private String color;
	private int age;
	private Paw[] paws;
	
	public Cat(String name, String color, int age, Paw[] paws) {
		this.name = name;
		this.color = color;
		this.age = age;
		this.paws = paws;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", color=" + color + ", age=" + age + "]";
	}
	
	
	
}
