package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
		
		CriteriaBuilder builder = s.getCriteriaBuilder();
		CriteriaQuery<Student> query = builder.createQuery(Student.class);
		
		Root<Student> root = query.from(Student.class);
		Join<Student, Teacher> join = root.join("teacher", JoinType.INNER);
		query.select(root).where(builder.equal(join.get("id"), t.getId()));
		return s.createQuery(query).getResultList();
	}
	

	 
	@Override
	public void insert(Student s) {
		Session sess = HibernateUtil.getSession();
		sess.save(s);
	}

	@Override
	public void update(Student s) {
		Session sess = HibernateUtil.getSession();
		sess.merge(s);
	}

	@Override
	public void delete(Student s) {
		Session sess = HibernateUtil.getSession();
		sess.delete(s);
	}

//	@Override
//	public List<Student> findAllByAge(int age) {
//		 /* Criteria API (Criteria Query API)
//		 * 		More complex than just the Query Interface
//		 * 		Type-safe and supports more nuanced queries
//		 */
//		Session s = HibernateUtil.getSession();
//		CriteriaBuilder builder = s.getCriteriaBuilder();
//		CriteriaQuery<Student> query = builder.createQuery(Student.class);
//		Root<Student> root = query.from(Student.class);
		//CriteriaQuery<Student> = query.select(root).where(builder.between(root.get("age"), 87, 87));
		
		//		query.select(root)
//				.where(builder.between(root.get("age"), 87, 87));
//		return query.get
		
	}

}
