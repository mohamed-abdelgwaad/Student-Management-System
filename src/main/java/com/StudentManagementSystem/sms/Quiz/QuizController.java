package com.StudentManagementSystem.sms.Quiz;

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
@RestController
public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService) {
        super();
        this.quizService = quizService;
    }

    @GetMapping("/view-quizzes")
    public List<Quiz> viewQuizzes() {
        return quizService.viewQuizzes();
    }

    @GetMapping("/view-quizzes/{id}")
    public EntityModel<Quiz> viewQuiz(@PathVariable int id) {
        return quizService.viewQuiz(id);
    }

    @DeleteMapping("/delete-quiz/{id}")
    public void deleteQuiz(@PathVariable int id) {
        quizService.deleteQuiz(id);
    }

    @PostMapping("/add-quiz")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
        quizService.addQuiz(quiz);
        return ResponseEntity.created(null).build();
    }

    @PutMapping("/update-quiz/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable int id, @RequestBody Quiz quiz) {
        quizService.updateQuiz(id, quiz);
        return ResponseEntity.created(null).build();
    }
    
    @PutMapping("/quiz-courses/{quiz_id}/{course_id}")
	public Quiz quizCourses(@PathVariable int quiz_id, @PathVariable int course_id) {
		
		return quizService.quizCourses(quiz_id, course_id);

	}
    
    
    
}