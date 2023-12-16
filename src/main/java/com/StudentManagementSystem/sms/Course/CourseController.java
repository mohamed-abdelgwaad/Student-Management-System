package com.StudentManagementSystem.sms.Course;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();

		this.courseService = courseService;
	}

	@GetMapping("/view-courses")
	public List<Course> viewCourses() {
		return courseService.viewCourses();

	}

	@GetMapping("/view-courses/{id}")
	public EntityModel<Course> viewCourse(@PathVariable int id) {
		return courseService.viewCourse(id);
	}

	@DeleteMapping("/delete-course/{id}")
	public void deleteCourse(@PathVariable int id) {
		courseService.deleteCourse(id);

	}

	@PostMapping("/add-course")
	public ResponseEntity<Course> addCourse(@RequestBody 
			Course course) {
		courseService.addCourse(course);
		return ResponseEntity.created(null).build();

	}

	@PutMapping("/update-course/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course course) {

		courseService.updateCourse(id, course);
		return ResponseEntity.created(null).build();

	}

}
