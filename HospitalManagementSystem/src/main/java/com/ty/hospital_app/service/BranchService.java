package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.BranchDaoImp;
import com.ty.hospital_app.dto.Branch;

public class BranchService {
	public void saveBranch(Branch branch,int hid) {
		BranchDaoImp bdi=new BranchDaoImp();
		Branch branch1=bdi.saveBranch(hid, branch);
		if(branch1!=null) {
			System.out.println("data saved");
		}
		else {
			System.out.println("unfortunately data not saved");
		}
	}
	
	public Branch getBranch(int bid) {
		BranchDaoImp bdi=new BranchDaoImp();
		Branch branch=bdi.getBranch(bid);
		if(branch!=null) {
			return branch;
		}
		else {
			return null;
		}
	}
	
	public void deleteBranch(int bid) {
		BranchDaoImp bdi=new BranchDaoImp();
		boolean flag=bdi.deleteBranchById(bid);
		if(flag==true) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not found");
		}
	}
	
	public Branch updateBranchById(int bid,Branch branch) {
		BranchDaoImp bdi=new BranchDaoImp();
		Branch branch1=bdi.updateBranchById(bid, branch);
		if(branch1!=null) {
			return branch1;
		}
		else {
			return null;
		}
	}
	
	public List<Branch> getAllBranches(){
		BranchDaoImp bdi=new BranchDaoImp();
		List<Branch> branches=bdi.getAllBranches();
		return branches;
	}
}
