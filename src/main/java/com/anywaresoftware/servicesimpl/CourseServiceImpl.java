package com.anywaresoftware.servicesimpl;

import com.anywaresoftware.daos.CourseDAO;
import com.anywaresoftware.daosimpl.CourseDAOImpl;
import com.anywaresoftware.models.Course;
import com.anywaresoftware.services.CourseService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

	private SessionFactory sessionFactory;

	private CourseDAO courseDAO;

	@Autowired
	public CourseServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		// Initialize courseDAO with the sessionFactory
		this.courseDAO = new CourseDAOImpl(sessionFactory);
	}

	@Override
	public Long addCourse(Course course) {
		return courseDAO.saveCourse(course);
	}

	@Override
	public Course getCourse(Long courseId) {
		return courseDAO.getCourseById(courseId);
	}

	@Override
	public List<Course> listCourses() {
		return courseDAO.getAllCourses();
	}

	@Override
	public void updateCourse(Course course) {
		courseDAO.updateCourse(course);
	}

	@Override
	public void removeCourse(Long courseId) {
		courseDAO.deleteCourse(courseId);
	}
}
