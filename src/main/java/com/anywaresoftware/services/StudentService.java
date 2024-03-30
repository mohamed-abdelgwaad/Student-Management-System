package com.anywaresoftware.services;

import com.anywaresoftware.models.Student;
import java.util.List;

public interface StudentService {
	Long addStudent(Student student);

	Student getStudent(Long studentId);

	List<Student> listStudents();

	void updateStudent(Student student);

	void removeStudent(Long studentId);
}
