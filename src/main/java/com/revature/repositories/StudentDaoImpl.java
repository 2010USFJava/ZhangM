package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.revature.models.Student;
import com.revature.models.Teacher;
import com.revature.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public Student findById(int id) {
		Session s = HibernateUtil.getSession();
		return s.get(Student.class, id);
	}

	@Override
	public Student findByName(String name) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("From Student s WHERE s.name = :name", Student.class);
		query.setParameter("name", name);
		Student student = (Student) query.getSingleResult();
		return student;
	}

	@Override
	public List<Student> findAll() {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("From Student s", Student.class);
		return (List<Student>) query.getResultList();
	}

	@Override
	public List<Student> findByTeacher(Teacher t) {
		Session s = HibernateUtil.getSession();
//		Query query = s.createQuery("From Student s WHERE s.teacher = :teacher", Student.class);
//		query.setParameter("teacher", t);
//		return (List<Student>) query.getResultList();
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		
		Root<Student> root = query.from(Student.class);
		Join<Student, Teacher> join = root.join("teacher", JoinType.INNER);
		query.select(root).where(builder.equal(join.get("id"), t.getId()));
		return s.createQuery(query).getResultList();
	}

	@Override
	public void insert(Student s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Student s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Student s) {
		// TODO Auto-generated method stub

	}

}
