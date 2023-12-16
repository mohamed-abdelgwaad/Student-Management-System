package com.StudentManagementSystem.sms.Teacher;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.sms.Course.Course;
import com.StudentManagementSystem.sms.Course.CourseRepo;

@Service
public class TeacherService {
    private TeacherRepo teacherRepo;
    private CourseRepo courseRepo;

    public TeacherService(CourseRepo courseRepo,TeacherRepo teacherRepo) {
        super();
        this.teacherRepo = teacherRepo;
        this.courseRepo=courseRepo;
    }

    public List<Teacher> viewTeachers() {
        return teacherRepo.findAll();
    }

    public EntityModel<Teacher> viewTeacher(int id) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        if (teacherOptional.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<Teacher> entityModel = EntityModel.of(teacherOptional.get());
        return entityModel;
    }

    public void deleteTeacher(int id) {
        teacherRepo.deleteById(id);
    }

    public ResponseEntity<Teacher> addTeacher(Teacher teacher) {
        teacherRepo.save(teacher);
        return ResponseEntity.created(null).build();
    }

    public ResponseEntity<Teacher> updateTeacher(int id, Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepo.findById(id);
        if (teacherOptional.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        Teacher existingTeacher = teacherOptional.get();
        existingTeacher.setCourseName(teacher.getCourseName());
        teacherRepo.save(existingTeacher);
        return ResponseEntity.created(null).build();
    }
    
    public Course coursesOfTeacher( int teacher_id,  int course_id) {
		Teacher teacher = teacherRepo.findById(teacher_id).get();
		Course course = courseRepo.findById(course_id).get();
		course.addteacher(teacher);
		return courseRepo.save(course);

	}
    
    
}

