package com.anywaresoftware.daosimpl;

import com.anywaresoftware.daos.QuizDAO;
import com.anywaresoftware.models.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuizDAOImpl implements QuizDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public QuizDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long saveQuiz(Quiz quiz) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Long id = (Long) session.save(quiz);
		transaction.commit();
		session.close();
		return id;
	}

	@Override
	public Quiz getQuizById(Long quizId) {
		Session session = sessionFactory.openSession();
		Quiz quiz = session.get(Quiz.class, quizId);
		session.close();
		return quiz;
	}

	@Override
	public List<Quiz> getAllQuizzes() {
		Session session = sessionFactory.openSession();
		List<Quiz> quizzes = session.createQuery("from Quiz", Quiz.class).list();
		session.close();
		return quizzes;
	}

	@Override
	public void updateQuiz(Quiz quiz) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(quiz);
		transaction.commit();
		session.close();
	}

	@Override
	public void deleteQuiz(Long quizId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Quiz quiz = session.get(Quiz.class, quizId);
		if (quiz != null) {
			session.delete(quiz);
		}
		transaction.commit();
		session.close();
	}
}
