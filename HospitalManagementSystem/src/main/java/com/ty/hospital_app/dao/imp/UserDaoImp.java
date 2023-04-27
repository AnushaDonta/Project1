package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.UserDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.User;

public class UserDaoImp implements UserDao{

	public User saveUser(User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
		return user;
	}

	public User getUserById(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		User user=entityManager.find(User.class, uid);
		return user;
	}

	public boolean deleteUserById(int uid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User user=entityManager.find(User.class, uid);
		
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public User updateUserById(int uid, User user) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		User user1=entityManager.find(User.class, uid);
		
		if(user1!=null) {
			user1.setName(user.getName());
			user1.setEmail(user.getEmail());
			
			entityTransaction.begin();
			entityManager.merge(user1);
			entityTransaction.commit();
			
			return user1;
		}
		else {
			return null;
		}
	}

	public List<User> getAllUsers() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select u from User u");
		List<User> users=query.getResultList();
		return users;
	}

	public List<User> getUsersByRole(String role) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select u from User u where s.role=?");
//		Query query=entityManager.createQuery("select u from User u where s.role like ?1");
		query.setParameter(1, role);
		List<User> users=query.getResultList();
		return users;
	}

}
