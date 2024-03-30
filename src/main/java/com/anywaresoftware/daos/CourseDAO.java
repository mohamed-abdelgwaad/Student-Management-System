package com.anywaresoftware.daos;

import com.anywaresoftware.models.Course;
import java.util.List;

public interface CourseDAO {
	Long saveCourse(Course course);

	Course getCourseById(Long courseId);

	List<Course> getAllCourses();

	void updateCourse(Course course);

	void deleteCourse(Long courseId);
}
