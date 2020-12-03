package com.revature.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity 
@Table(name = "teacher")
public class Teacher {
	@Id
	private int id;
	private String name;
	private String subject;
	
	@ManyToOne
	private Set<Student> students;
}
