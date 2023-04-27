package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Branch;

public interface BranchDao {
	Branch saveBranch(int hid,Branch branch);
	Branch getBranch(int bid);
	boolean deleteBranchById(int bid);
	Branch updateBranchById(int bid,Branch branch);
	List<Branch> getAllBranches();
}
