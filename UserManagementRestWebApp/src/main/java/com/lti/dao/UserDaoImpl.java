package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.entity.User;

//@Component
@Repository
public class UserDaoImpl implements UserDao {

	// EntityManagerFactory emf;

	@PersistenceContext
	EntityManager em;
	// EntityTransaction tx;

//	public UserDaoImpl() {
//emf = Persistence.createEntityManagerFactory("oracle-pu");
//		em = emf.createEntityManager();
//		tx = em.getTransaction();
//	}
	@Transactional
	public User addOrUpdate(User user) {
		// tx.begin();
		User userPersisted = em.merge(user);
		// tx.commit();
		return userPersisted;

	}

	public User searchUserById(int userId) {
		return em.find(User.class, userId);
	}

	public List<User> viewAllUsers() {
		String jpql = "select u from User u";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		return query.getResultList();
	}

	public boolean login(int userId, String password) {
		String jpql = "select u from User u where u.userId=:uid and u.password=: pwd";
		TypedQuery<User> query = em.createQuery(jpql, User.class);

		query.setParameter("uid", userId);
		query.setParameter("pwd", password);
		User user = null;

		try {
			user = query.getSingleResult();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String getUserName(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
