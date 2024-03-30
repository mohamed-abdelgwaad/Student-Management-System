package com.anywaresoftware.daosimpl;

import com.anywaresoftware.daos.CourseDAO;
import com.anywaresoftware.models.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseDAOImpl implements CourseDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public CourseDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long saveCourse(Course course) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(course);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Course getCourseById(Long courseId) {
		Session session = sessionFactory.openSession();
		Course course = session.get(Course.class, courseId);
		session.close();
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		Session session = sessionFactory.openSession();
		List<Course> courses = session.createQuery("from Course", Course.class).list();
		session.close();
		return courses;
	}

	@Override
	public void updateCourse(Course course) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(course);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteCourse(Long courseId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Course course = session.get(Course.class, courseId);
		if (course != null) {
			session.delete(course);
		}
		transaction.commit();
		session.close();
	}
}
