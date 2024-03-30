package com.anywaresoftware.services;

import com.anywaresoftware.models.Quiz;
import java.util.List;

public interface QuizService {
	Long addQuiz(Quiz quiz);

	Quiz getQuiz(Long quizId);

	List<Quiz> listQuizzes();

	void updateQuiz(Quiz quiz);

	void removeQuiz(Long quizId);
}
