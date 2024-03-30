package com.anywaresoftware.daosimpl;

import com.anywaresoftware.daos.TeacherDAO;
import com.anywaresoftware.models.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public TeacherDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long saveTeacher(Teacher teacher) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(teacher);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Teacher getTeacherById(Long teacherId) {
		Session session = sessionFactory.openSession();
		Teacher teacher = session.get(Teacher.class, teacherId);
		session.close();
		return teacher;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		Session session = sessionFactory.openSession();
		List<Teacher> teachers = session.createQuery("from Teacher", Teacher.class).list();
		session.close();
		return teachers;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(teacher);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteTeacher(Long teacherId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Teacher teacher = session.get(Teacher.class, teacherId);
		if (teacher != null) {
			session.delete(teacher);
		}
		transaction.commit();
		session.close();
	}
}
