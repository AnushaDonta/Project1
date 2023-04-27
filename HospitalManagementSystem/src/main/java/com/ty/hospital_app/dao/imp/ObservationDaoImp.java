package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.ObservationDao;
import com.ty.hospital_app.dto.Encounter;
import com.ty.hospital_app.dto.Observation;

public class ObservationDaoImp implements ObservationDao{

	public Observation saveObservation(int eid, Observation observation) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Encounter encounter=entityManager.find(Encounter.class, eid);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.persist(observation);
			entityTransaction.commit();
			
			return observation;
		}
		else {
			return null;
		}
	}

	public Observation getObservationById(int oid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Observation observation=entityManager.find(Observation.class, oid);
		return observation;
	}

	public boolean deleteObservationById(int oid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Observation observation=entityManager.find(Observation.class, oid);
		
		if(observation!=null) {
			entityTransaction.begin();
			entityManager.remove(observation);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Observation updateObservationById(int oid, Observation observation) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Observation observation1=entityManager.find(Observation.class, oid);
		
		if(observation1!=null) {
			observation1.setDname(observation.getDname());
			observation1.setReasonObservation(observation.getReasonObservation());
			entityTransaction.begin();
			entityManager.merge(observation1);
			entityTransaction.commit();
			
			return observation1;
		}
		else {
			return null;
		}
	}

	public List<Observation> getAllObservations() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select o from Observation o");
		List<Observation> observations=query.getResultList();
		return observations;
	}

	public List<Observation> getObservationsByDoctorName(String dname) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select o from Observation o where o.dname like ?1");
		query.setParameter(1, dname);
		List<Observation> observations=query.getResultList();
		return observations;
	}

}
