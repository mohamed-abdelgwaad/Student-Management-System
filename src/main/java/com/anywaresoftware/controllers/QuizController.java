package com.anywaresoftware.controllers;

import com.anywaresoftware.models.Quiz;
import com.anywaresoftware.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

	private final QuizService quizService;

	@Autowired
	public QuizController(QuizService quizService) {
		this.quizService = quizService;
	}

	@PostMapping(consumes = "application/json")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz) {
		Long quizId = quizService.addQuiz(quiz);
		quiz.setQuizId(quizId);
		return new ResponseEntity<>(quiz, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Quiz> getQuiz(@PathVariable("id") Long quizId) {
		Quiz quiz = quizService.getQuiz(quizId);
		if (quiz != null) {
			return new ResponseEntity<>(quiz, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping(consumes = "application/json")
	public ResponseEntity<List<Quiz>> listQuizzes() {
		List<Quiz> quizzes = quizService.listQuizzes();
		return new ResponseEntity<>(quizzes, HttpStatus.OK);
	}

	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") Long quizId, @RequestBody Quiz quiz) {
		Quiz existingQuiz = quizService.getQuiz(quizId);
		if (existingQuiz != null) {
			existingQuiz.setQuizName(quiz.getQuizName());
			// Update other fields as needed
			quizService.updateQuiz(existingQuiz);
			return new ResponseEntity<>(existingQuiz, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<Void> removeQuiz(@PathVariable("id") Long quizId) {
		Quiz quiz = quizService.getQuiz(quizId);
		if (quiz != null) {
			quizService.removeQuiz(quizId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
