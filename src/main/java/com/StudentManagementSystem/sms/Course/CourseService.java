package com.StudentManagementSystem.sms.Course;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseService  {
	private CourseRepo  courseRepo;

	public CourseService(CourseRepo  courseRepo) {
		super();
		this.courseRepo = courseRepo;
	}

	public List<Course> viewCourses() {
		return courseRepo.findAll();

	}

	public EntityModel<Course> viewCourse(int id) {
		Optional<Course> courseOptional  = courseRepo.findById(id);
		if (courseOptional .isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		EntityModel<Course> entityModel = EntityModel.of(courseOptional.get());

		return entityModel;
	}

	public void deleteCourse(int id) {
		courseRepo.deleteById(id);

	}

	public ResponseEntity<Course> addCourse(Course course) {
		courseRepo.save(course);
		return ResponseEntity.created(null).build();

	}

	public ResponseEntity<Course> updateCourse(int id, Course course) {

		Optional<Course> courseOptional  = courseRepo.findById(id);
		if (courseOptional.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		 Course existingCourse = courseOptional.get();
		 existingCourse.setClassNum(course.getClassNum());
		 existingCourse.setNumOfStudents(course.getNumOfStudents());
		courseRepo.save(existingCourse);
		return ResponseEntity.created(null).build();

	}

}
