package com.revature.driver;

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
		
		System.out.println(studentDao.findAll());
		
		Teacher teacher = new Teacher(0, "OGMatt", "java", null);
		s.save(teacher);
		tx.commit();
		System.out.println(studentDao.findByTeacher(teacher));
		
	}

}
