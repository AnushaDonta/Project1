package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.AddressDaoImp;
import com.ty.hospital_app.dto.Address;

public class AddressService {
	public void saveAddress(Address address,int bid) {
		AddressDaoImp adi=new AddressDaoImp();
		Address address1=adi.saveAddress(bid, address);
		if(address1!=null) {
			System.out.println("data saved");
		}
		else {
			System.out.println("unfortunately data not saved");
		}
	}
	
	public Address getAddress(int aid) {
		AddressDaoImp adi=new AddressDaoImp();
		Address address=adi.getAddressById(aid);
		if(address!=null) {
			return address;
		}
		else {
			return null;
		}
	}
	
	public void deleteAddress(int aid) {
		AddressDaoImp adi=new AddressDaoImp();
		boolean flag=adi.deleteAddressById(aid);
		if(flag==true) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not found");
		}
	}
	
	public Address updateAddressById(int aid,Address address) {
		AddressDaoImp adi=new AddressDaoImp();
		Address address1=adi.updateAddressById(aid, address);
		if(address1!=null) {
			return address1;
		}
		else {
			return null;
		}
	}
	
	public List<Address> getAllAddresses(){
		AddressDaoImp adi=new AddressDaoImp();
		List<Address> addresses=adi.getAllAddresses();
		return addresses;
	}
}
