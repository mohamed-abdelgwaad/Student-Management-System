package com.anywaresoftware.servicesimpl;

import com.anywaresoftware.daos.StudentDAO;
import com.anywaresoftware.daosimpl.StudentDAOImpl;
import com.anywaresoftware.models.Student;
import com.anywaresoftware.services.StudentService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	private final SessionFactory sessionFactory;
	private final StudentDAO studentDAO;

	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		// Initialize studentDAO with the sessionFactory
		this.studentDAO = new StudentDAOImpl(sessionFactory);
	}

	@Override
	public Long addStudent(Student student) {
		return studentDAO.saveStudent(student);
	}

	@Override
	public Student getStudent(Long studentId) {
		return studentDAO.getStudentById(studentId);
	}

	@Override
	public List<Student> listStudents() {
		return studentDAO.getAllStudents();
	}

	@Override
	public void updateStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(Long studentId) {
		studentDAO.deleteStudent(studentId);
	}
}
