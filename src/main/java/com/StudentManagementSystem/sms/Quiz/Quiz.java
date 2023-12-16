package com.StudentManagementSystem.sms.Quiz;

import java.util.HashSet;
import java.util.Set;

import com.StudentManagementSystem.sms.Course.Course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	public Quiz() {
	}

	@Id
	@GeneratedValue
	 private int id;
    private String courseName;
    private String quizType;
    
    
    @ManyToMany
    @JoinTable(name = "quiz_courses", joinColumns = @JoinColumn(name = "quiz_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> coursesQ=new HashSet<>();
    
	public Quiz(int id, String courseName, String quizType) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.quizType = quizType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getQuizType() {
		return quizType;
	}
	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}

	public Set<Course> getCoursesQ() {
		return coursesQ;
	}
	public void setCoursesQ(Set<Course> coursesQ) {
		this.coursesQ = coursesQ;
	}
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", courseName=" + courseName + ", quizType=" + quizType + "]";
	}
	public void addcourse(Course course) {
		coursesQ.add(course);
		
	}

	

}
