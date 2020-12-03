package com.revature.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString(exclude = {"teacher"})
public class Student {
	private int id;
	private String name;
	private int age;
	
	private Teacher teacher;
	
}
