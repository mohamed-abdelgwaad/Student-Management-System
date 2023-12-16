package com.StudentManagementSystem.sms.Quiz;

import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.sms.Course.Course;
import com.StudentManagementSystem.sms.Course.CourseRepo;
@Service
public class QuizService {
    private QuizRepo quizRepo;
private CourseRepo courseRepo;
    public QuizService(CourseRepo courseRepo,QuizRepo quizRepo) {
        super();
        this.quizRepo = quizRepo;
        this.courseRepo=courseRepo;
    }

    public List<Quiz> viewQuizzes() {
        return quizRepo.findAll();
    }

    public EntityModel<Quiz> viewQuiz(int id) {
        Optional<Quiz> quizOptional = quizRepo.findById(id);
        if (quizOptional.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        EntityModel<Quiz> entityModel = EntityModel.of(quizOptional.get());
        return entityModel;
    }

    public void deleteQuiz(int id) {
        quizRepo.deleteById(id);
    }

    public ResponseEntity<Quiz> addQuiz(Quiz quiz) {
        quizRepo.save(quiz);
        return ResponseEntity.created(null).build();
    }

    public ResponseEntity<Quiz> updateQuiz(int id, Quiz quiz) {
        Optional<Quiz> quizOptional = quizRepo.findById(id);
        if (quizOptional.isEmpty()) {
            throw new UserNotFoundException("id:" + id);
        }
        Quiz existingQuiz = quizOptional.get();
        existingQuiz.setQuizType(quiz.getQuizType());
        quizRepo.save(existingQuiz);
        return ResponseEntity.created(null).build();
    }
    
    public Quiz quizCourses( int quiz_id,  int course_id) {
    	Quiz quiz = quizRepo.findById(quiz_id).get();
		Course course = courseRepo.findById(course_id).get();
		quiz.addcourse(course);
		return quizRepo.save(quiz);

	}
	
	
    
    
    
    
}
