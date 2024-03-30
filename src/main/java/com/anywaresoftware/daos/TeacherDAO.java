package com.anywaresoftware.daos;

import com.anywaresoftware.models.Teacher;
import java.util.List;

public interface TeacherDAO {
	Long saveTeacher(Teacher teacher);

	Teacher getTeacherById(Long teacherId);

	List<Teacher> getAllTeachers();

	void updateTeacher(Teacher teacher);

	void deleteTeacher(Long teacherId);
}
