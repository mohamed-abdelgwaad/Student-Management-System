package com.anywaresoftware.services;

import com.anywaresoftware.models.Teacher;
import java.util.List;

public interface TeacherService {
	Long addTeacher(Teacher teacher);

	Teacher getTeacher(Long teacherId);

	List<Teacher> listTeachers();

	void updateTeacher(Teacher teacher);

	void removeTeacher(Long teacherId);
}
