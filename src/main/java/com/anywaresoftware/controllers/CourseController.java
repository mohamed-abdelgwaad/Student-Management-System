package com.anywaresoftware.controllers;

import com.anywaresoftware.models.Course;
import com.anywaresoftware.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

	private final CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Long courseId = courseService.addCourse(course);
		course.setCourseId(courseId);
		return new ResponseEntity<>(course, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Course> getCourse(@PathVariable("id") Long courseId) {
		Course course = courseService.getCourse(courseId);
		if (course != null) {
			return new ResponseEntity<>(course, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(consumes = "application/json")
	public ResponseEntity<List<Course>> listCourses() {
		List<Course> courses = courseService.listCourses();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") Long courseId, @RequestBody Course course) {
		Course existingCourse = courseService.getCourse(courseId);
		if (existingCourse != null) {
			existingCourse.setCourseName(course.getCourseName());
			// Update other fields as needed
			courseService.updateCourse(existingCourse);
			return new ResponseEntity<>(existingCourse, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Void> removeCourse(@PathVariable("id") Long courseId) {
		Course course = courseService.getCourse(courseId);
		if (course != null) {
			courseService.removeCourse(courseId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
