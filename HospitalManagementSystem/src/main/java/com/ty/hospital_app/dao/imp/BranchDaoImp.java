package com.ty.hospital_app.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital_app.dao.BranchDao;
import com.ty.hospital_app.dto.Branch;
import com.ty.hospital_app.dto.Hospital;

public class BranchDaoImp implements BranchDao{

	public Branch saveBranch(int hid, Branch branch) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Hospital hospital=entityManager.find(Hospital.class, hid);
		if(hospital!=null) {
			entityTransaction.begin();
			entityManager.persist(branch);
			entityTransaction.commit();
			
			return branch;
		}
		else {
			return null;
		}
	}

	public Branch getBranch(int bid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Branch branch=entityManager.find(Branch.class, bid);
		return branch;
	}

	public boolean deleteBranchById(int bid) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch=entityManager.find(Branch.class, bid);
		
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}

	public Branch updateBranchById(int bid, Branch branch) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Branch branch1=entityManager.find(Branch.class, bid);
		
		if(branch1!=null) {
			branch1.setName(branch.getName());
			branch1.setAddresses(branch.getAddresses());
			branch1.setEmail(branch.getEmail());
			entityTransaction.begin();
			entityManager.merge(branch1);
			entityTransaction.commit();
			
			return branch1;
		}
		else {
			return null;
		}
	}

	public List<Branch> getAllBranches() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("select b from Branch b");
		List<Branch> branches=query.getResultList();
		return branches;
	}

}
