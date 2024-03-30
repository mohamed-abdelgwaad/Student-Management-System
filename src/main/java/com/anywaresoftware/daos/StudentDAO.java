package com.anywaresoftware.daos;

import com.anywaresoftware.models.Student;
import java.util.List;

public interface StudentDAO {
	Long saveStudent(Student student);

	Student getStudentById(Long studentId);

	List<Student> getAllStudents();

	void updateStudent(Student student);

	void deleteStudent(Long studentId);
}