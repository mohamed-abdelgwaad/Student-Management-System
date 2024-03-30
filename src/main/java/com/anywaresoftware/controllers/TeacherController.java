package com.anywaresoftware.controllers;

import com.anywaresoftware.models.Teacher;
import com.anywaresoftware.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	private final TeacherService teacherService;

	@Autowired
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
		Long teacherId = teacherService.addTeacher(teacher);
		teacher.setTeacherId(teacherId);
		return new ResponseEntity<>(teacher, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Teacher> getTeacher(@PathVariable("id") Long teacherId) {
		Teacher teacher = teacherService.getTeacher(teacherId);
		if (teacher != null) {
			return new ResponseEntity<>(teacher, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(consumes = "application/json")
	public ResponseEntity<List<Teacher>> listTeachers() {
		List<Teacher> teachers = teacherService.listTeachers();
		return new ResponseEntity<>(teachers, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Long teacherId,
			@RequestBody Teacher updatedTeacher) {
		Teacher teacher = teacherService.getTeacher(teacherId);
		if (teacher != null) {
			teacher.setTeacherName(updatedTeacher.getTeacherName());
			teacher.setAge(updatedTeacher.getAge());
			teacher.setEmail(updatedTeacher.getEmail());
			// Optionally update the Course relationship if needed
			teacherService.updateTeacher(teacher);
			return new ResponseEntity<>(teacher, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Void> removeTeacher(@PathVariable("id") Long teacherId) {
		Teacher existingTeacher = teacherService.getTeacher(teacherId);
		if (existingTeacher != null) {
			teacherService.removeTeacher(teacherId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
