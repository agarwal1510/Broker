package com.sapient.jpaImplementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.dao.UserDao;
import com.sapient.entity.User;
@Repository
public class UserDaoJPAImplementation implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void addUser(User user) {
		entityManager.persist(user);
	}

	public User getUser(int userId) {
		return entityManager.find(User.class, userId);
	}

	public List<User> getUserByName(String userName) {
		List<User> list = new ArrayList<>();
		TypedQuery<User> query = entityManager.createNamedQuery("findAll",
				User.class).setParameter("userName", userName);
		list = query.getResultList();
		return list;

	}

	

}
