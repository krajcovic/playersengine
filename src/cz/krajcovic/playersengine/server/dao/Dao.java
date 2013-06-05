package cz.krajcovic.playersengine.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import cz.krajcovic.playersengine.server.model.Todo;

public enum Dao {
	INSTANCE;

	public List<Todo> listTodos() {
		EntityManager em = EMFService.get().createEntityManager();

		// Read the existing entries
		Query q = em.createQuery("select m from Todo m");
		// List<?> todos = q.getResultList();
		return q.getResultList();
	}

	public void add(String userId, String summary, String description,
			String url) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			em.persist(new Todo(userId, summary, description, url));
			em.close();
		}
	}

	public List<Todo> getTodos(String userId) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em
				.createQuery("select t from Todo t where t.author = :userId");
		q.setParameter("userId", userId);

		return q.getResultList();
	}

	public void remove(long id) {
		EntityManager em = EMFService.get().createEntityManager();
		try {
			Todo todo = em.find(Todo.class, id);
			em.remove(todo);
		}
		finally{
			em.close();
		}
	}
}
