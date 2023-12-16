package com.StudentManagementSystem.sms.Student;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.sms.Course.Course;
import com.StudentManagementSystem.sms.Course.CourseRepo;

@Service
public class StudentService {
	private StudentRepo studentRepo;
	private CourseRepo courseRepo;
	public StudentService(CourseRepo courseRepo,StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
		this.courseRepo=courseRepo;
	}

	public List<Student> viewStudents() {
		return studentRepo.findAll();
	}

	public EntityModel<Student> viewStudent(int id) {
		Optional<Student> studentOptional = studentRepo.findById(id);
		if (studentOptional.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		EntityModel<Student> entityModel = EntityModel.of(studentOptional.get());
		return entityModel;
	}

	public void deleteStudent(int id) {
		studentRepo.deleteById(id);
	}

	public ResponseEntity<Student> addStudent(Student student) {
		studentRepo.save(student);
		return ResponseEntity.created(null).build();
	}

	public ResponseEntity<Student> updateStudent(int id, Student student) {
		Optional<Student> studentOptional = studentRepo.findById(id);
		if (studentOptional.isEmpty()) {
			throw new UserNotFoundException("id:" + id);
		}
		Student existingStudent = studentOptional.get();
		existingStudent.setClassNum(student.getClassNum());
		studentRepo.save(existingStudent);
		return ResponseEntity.created(null).build();
	}
	
	public Student enrollStudents( int student_id,  int course_id) {
		Student student = studentRepo.findById(student_id).get();
		Course course = courseRepo.findById(course_id).get();
		student.addcourse(course);
		return studentRepo.save(student);

	}
	
	
	
	
	
}
