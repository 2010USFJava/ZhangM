package com.revature.repositories;

import java.util.List;
import java.util.Set;

import com.revature.models.Student;
import com.revature.models.Teacher;


public interface StudentDao {
	public Student findById(int id);
	public Student findByName(String name);
	public List<Student> findAll();
	public List<Student> findByTeacher(Teacher t);
	public void insert(Student s);
	public void update(Student s);
	public void delete(Student s);
}
