package com.anywaresoftware.servicesimpl;

import com.anywaresoftware.daos.QuizDAO;
import com.anywaresoftware.daosimpl.QuizDAOImpl;
import com.anywaresoftware.models.Quiz;
import com.anywaresoftware.services.QuizService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

	private final SessionFactory sessionFactory;
	private final QuizDAO quizDAO;

	@Autowired
	public QuizServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		// Initialize quizDAO with the sessionFactory
		this.quizDAO = new QuizDAOImpl(sessionFactory);
	}

	@Override
	public Long addQuiz(Quiz quiz) {
		return quizDAO.saveQuiz(quiz);
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		return quizDAO.getQuizById(quizId);
	}

	@Override
	public List<Quiz> listQuizzes() {
		return quizDAO.getAllQuizzes();
	}

	@Override
	public void updateQuiz(Quiz quiz) {
		quizDAO.updateQuiz(quiz);
	}

	@Override
	public void removeQuiz(Long quizId) {
		quizDAO.deleteQuiz(quizId);
	}
}
