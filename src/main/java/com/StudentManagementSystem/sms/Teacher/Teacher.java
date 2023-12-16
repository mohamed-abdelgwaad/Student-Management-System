package com.StudentManagementSystem.sms.Teacher;

import java.util.HashSet;
import java.util.Set;

import com.StudentManagementSystem.sms.Course.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {
    public Teacher() {
    }

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String courseName;
	
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses = new HashSet<>();
    
	public Teacher(int id, String name, String courseName) {
		super();
		this.id = id;
		this.name = name;
		this.courseName = courseName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", courseName=" + courseName + "]";
	}



}
