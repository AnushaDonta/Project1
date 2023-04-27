package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Address;

public interface AddressDao {
	Address saveAddress(int bid,Address address);
	Address getAddressById(int aid);
	boolean deleteAddressById(int aid);
	Address updateAddressById(int aid,Address address);
	List<Address> getAllAddresses();
}