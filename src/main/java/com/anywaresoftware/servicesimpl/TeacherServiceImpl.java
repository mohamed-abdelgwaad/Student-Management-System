package com.anywaresoftware.servicesimpl;

import com.anywaresoftware.daos.TeacherDAO;
import com.anywaresoftware.daosimpl.TeacherDAOImpl;
import com.anywaresoftware.models.Teacher;
import com.anywaresoftware.services.TeacherService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

	private final SessionFactory sessionFactory;
	private final TeacherDAO teacherDAO;

	@Autowired
	public TeacherServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		this.teacherDAO = new TeacherDAOImpl(sessionFactory);
	}

	@Override
	public Long addTeacher(Teacher teacher) {
		return teacherDAO.saveTeacher(teacher);
	}

	@Override
	public Teacher getTeacher(Long teacherId) {
		return teacherDAO.getTeacherById(teacherId);
	}

	@Override
	public List<Teacher> listTeachers() {
		return teacherDAO.getAllTeachers();
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		teacherDAO.updateTeacher(teacher);
	}

	@Override
	public void removeTeacher(Long teacherId) {
		teacherDAO.deleteTeacher(teacherId);
	}
}
