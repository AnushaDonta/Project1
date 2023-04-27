package com.ty.hospital_app.service;

import com.ty.hospital_app.dao.imp.HospitalDaoImp;
import com.ty.hospital_app.dto.Hospital;

public class HospitalService {
	public void saveHospital(Hospital hospital) {
		HospitalDaoImp hdi=new HospitalDaoImp();
		Hospital hospital1=hdi.saveHospital(hospital);
		if(hospital1!=null) {
			System.out.println("data saved");
		}
		else {
			System.out.println("unfortunately data not saved");
		}
	}
	
	public Hospital getHospital(int hid) {
		HospitalDaoImp hdi=new HospitalDaoImp();
		Hospital hospital=hdi.getHospitalById(hid);
		if(hospital!=null) {
			return hospital;
		}
		else {
			return null;
		}
	}
	
	public void deleteHospital(int hid) {
		HospitalDaoImp hdi=new HospitalDaoImp();
		boolean flag=hdi.deleteHospitalById(hid);
		if(flag==true) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not found");
		}
	}
	
	public Hospital updateHospitalById(int hid,Hospital hospital) {
		HospitalDaoImp hdi=new HospitalDaoImp();
		Hospital hospital1=hdi.updateHospitalById(hid, hospital);
		if(hospital1!=null) {
			return hospital1;
		}
		else {
			return null;
		}
	}
}
