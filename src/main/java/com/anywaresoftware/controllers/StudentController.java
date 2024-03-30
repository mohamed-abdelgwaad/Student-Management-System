package com.anywaresoftware.controllers;

import com.anywaresoftware.models.Student;
import com.anywaresoftware.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Long studentId = studentService.addStudent(student);
		student.setStudentId(studentId);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Student> getStudent(@PathVariable("id") Long studentId) {
		Student student = studentService.getStudent(studentId);
		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(consumes = "application/json")
	public ResponseEntity<List<Student>> listStudents() {
		List<Student> students = studentService.listStudents();
		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentId, @RequestBody Student student) {
		Student existingStudent = studentService.getStudent(studentId);
		if (existingStudent != null) {
			existingStudent.setStudentName(student.getStudentName());
			existingStudent.setAge(student.getAge());
			existingStudent.setEmail(student.getEmail());
			// Consider adding logic to update the Course if applicable
			studentService.updateStudent(existingStudent);
			return new ResponseEntity<>(existingStudent, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Void> removeStudent(@PathVariable("id") Long studentId) {
		Student existingStudent = studentService.getStudent(studentId);
		if (existingStudent != null) {
			studentService.removeStudent(studentId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
