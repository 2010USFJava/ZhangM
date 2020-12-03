package com.revature.driver;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Student;
import com.revature.models.Teacher;
import com.revature.repositories.StudentDao;
import com.revature.repositories.StudentDaoImpl;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {

		Student student = new Student(0, "Esrat", 25, null);
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		// Will perform either an INSERT or an UPDATE
		s.save(student);

	
		
		Student fromDB = s.get(Student.class, 1);
		System.out.println(fromDB);
		
		StudentDao studentDao = new StudentDaoImpl();
		System.out.println(studentDao.findByName("Esrat"));
		
		Student student2 = new Student(0, "Michelle", 22, null);
		Student student3 = new Student(0, "Stephanie", 87, null);
		s.save(student2);
		s.save(student3);
		
		
		List<Student> studentList = studentDao.findAll();
		System.out.println(studentList);
		
		Teacher teacher = new Teacher(0, "OGMatt", "java", null);
//		teacher.setStudents(new HashSet<>(studentList));
		for (Student stu : studentList) {
			stu.setTeacher(teacher);
		}
		
		s.save(teacher);
		tx.commit();
		System.out.println("Find by teacher: " + studentDao.findByTeacher(teacher));
		
	}

}
