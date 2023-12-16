package com.StudentManagementSystem.sms.Teacher;

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

import com.StudentManagementSystem.sms.Course.Course;

@RestController
public class TeacherController {

    private TeacherService teacherService;

    public TeacherController(TeacherRepo teacherRepo, TeacherService teacherService) {
        super();
        this.teacherService = teacherService;
    }

    @GetMapping("/view-teachers")
    public List<Teacher> viewTeachers() {
        return teacherService.viewTeachers();
    }

    @GetMapping("/view-teachers/{id}")
    public EntityModel<Teacher> viewTeacher(@PathVariable int id) {
        return teacherService.viewTeacher(id);
    }

    @DeleteMapping("/delete-teacher/{id}")
    public void deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/teacher_courses/{teacher_id}/{course_id}")
	public Course enrolledStudents(@PathVariable int teacher_id, @PathVariable int course_id) {
		
		return teacherService.coursesOfTeacher(teacher_id, course_id);

	}
 
    
    @PutMapping("/update-teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        teacherService.updateTeacher(id, teacher);
        return ResponseEntity.created(null).build();
    }
}
