package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.PersonDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Person;
import com.ty.hospital_app.dto.User;

public class PersonDaoImp implements PersonDao{

	public Person savePerson(int eid, Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			
			return person;
		}
		else {
			return null;
		}
	}

	public Person getPersonById(int pid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Person person=entityManager.find(Person.class, pid);
		return person;
	}

	public boolean deletePersonById(int pid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person=entityManager.find(Person.class, pid);
		
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Person updatePersonById(int pid, Person person) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Person person1=entityManager.find(Person.class, pid);
		
		if(person1!=null) {
			person1.setAddress(person.getAddress());
			person1.setAge(person.getAge());
			person1.setGender(person.getGender());
			entityTransaction.begin();
			entityManager.merge(person1);
			entityTransaction.commit();
			
			return person1;
		}
		else {
			return null;
		}
	}

	public List<Person> getAllPersons() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select p from Person p");
		List<Person> persons=query.getResultList();
		return persons;
	}

	public List<Person> getPersonsByGender(String gender) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select p from Person p where p.gender=?");
//		Query query=entityManager.createQuery("select p from Person p where p.gender like ?1");
		query.setParameter(1, gender);
		List<Person> persons=query.getResultList();
		return persons;

	}

	public List<Person> getPersonsByAge(int age) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select p from Person p where p.age like ?1");
		query.setParameter(1, age);
		List<Person> persons=query.getResultList();
		return persons;
	}

	public List<Person> getPersonsByPhono(long phono) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select p from Person p where p.phono like ?1");
		query.setParameter(1, phono);
		List<Person> persons=query.getResultList();
		return persons;
	}

}
