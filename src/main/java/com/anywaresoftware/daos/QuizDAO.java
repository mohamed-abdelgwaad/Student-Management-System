package com.anywaresoftware.daos;

import com.anywaresoftware.models.Quiz;
import java.util.List;

public interface QuizDAO {
	Long saveQuiz(Quiz quiz);

	Quiz getQuizById(Long quizId);

	List<Quiz> getAllQuizzes();

	void updateQuiz(Quiz quiz);

	void deleteQuiz(Long quizId);
}
