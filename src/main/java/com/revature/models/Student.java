package com.revature.models;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString(exclude = {"teacher"})
public class Student {
	private int id;
	private String name;
	private int age;
	
	//@JsonBackReference
	private Teacher teacher;
	
}
