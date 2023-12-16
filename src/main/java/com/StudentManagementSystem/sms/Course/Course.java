package com.StudentManagementSystem.sms.Course;

import java.util.HashSet;
import java.util.Set;

import com.StudentManagementSystem.sms.Quiz.Quiz;
import com.StudentManagementSystem.sms.Student.Student;
import com.StudentManagementSystem.sms.Teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Course {
	public Course() {
	}

	@Id
	@GeneratedValue
	private int id;

	private String name;
	private int numOfStudents;
	private int classNum;

	@JsonIgnore
	@ManyToMany(mappedBy = "courses")
	private Set<Student> students = new HashSet<>();
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_id",referencedColumnName = "id")
	private Teacher teacher;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "coursesQ")
	private Set<Quiz> quizs=new HashSet<>();

	public Course(int id, String name, int numOfStudents, int classNum) {
		super();
		this.id = id;
		this.name = name;
		this.numOfStudents = numOfStudents;
		this.classNum = classNum;

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

	public int getNumOfStudents() {
		return numOfStudents;
	}

	public void setNumOfStudents(int numOfStudents) {
		this.numOfStudents = numOfStudents;
	}

	public int getClassNum() {
		return classNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<Quiz> getQuizs() {
		return quizs;
	}

	public void setQuizs(Set<Quiz> quizs) {
		this.quizs = quizs;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", numOfStudents=" + numOfStudents + ", classNum=" + classNum
				+ "]";
	}

	public void addteacher(Teacher teacher2) {
		this.teacher=teacher2;
		
	}

}
