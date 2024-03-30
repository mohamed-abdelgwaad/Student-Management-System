package com.anywaresoftware.daosimpl;

import com.anywaresoftware.daos.StudentDAO;
import com.anywaresoftware.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public StudentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long saveStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(student);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Student getStudentById(Long studentId) {
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, studentId);
		session.close();
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = sessionFactory.openSession();
		List<Student> students = session.createQuery("from Student", Student.class).list();
		session.close();
		return students;
	}

	@Override
	public void updateStudent(Student student) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(student);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteStudent(Long studentId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = session.get(Student.class, studentId);
		if (student != null) {
			session.delete(student);
		}
		transaction.commit();
		session.close();
	}
}
