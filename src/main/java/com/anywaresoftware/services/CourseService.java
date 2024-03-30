package com.anywaresoftware.services;

import com.anywaresoftware.models.Course;
import java.util.List;

public interface CourseService {
	Long addCourse(Course course);

	Course getCourse(Long courseId);

	List<Course> listCourses();

	void updateCourse(Course course);

	void removeCourse(Long courseId);
}
