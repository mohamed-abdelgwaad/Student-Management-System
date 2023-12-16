package com.StudentManagementSystem.sms.Student;

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
public class StudentController {


	private StudentService studentService;

	public StudentController( StudentService studentService) {
		super();
		this.studentService = studentService;
	
	}

	@GetMapping("/view-students")
	public List<Student> viewStudents() {
		return studentService.viewStudents();
	}

	@GetMapping("/view-students/{id}")
	public EntityModel<Student> viewStudent(@PathVariable int id) {
		return studentService.viewStudent(id);
	}

	@DeleteMapping("/delete-student/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}

	@PostMapping("/add-student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return ResponseEntity.created(null).build();
	}

	@PutMapping("/enroll-students/{student_id}/{course_id}")
	public Student enrolledStudents(@PathVariable int student_id, @PathVariable int course_id) {
		
		return studentService.enrollStudents(student_id, course_id);

	}

	@PutMapping("/update-student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
		return ResponseEntity.created(null).build();
	}
}
