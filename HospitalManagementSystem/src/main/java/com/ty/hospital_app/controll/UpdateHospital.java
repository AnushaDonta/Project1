package com.ty.hospital_app.controll;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class UpdateHospital {
	public static void main(String[] args) {
		Hospital hospital=new Hospital();
		hospital.setName("jayadevkumar");
		hospital.setWebsite("www.jayadevkumar.com");
		HospitalService service=new HospitalService();
		service.updateHospitalById(2, hospital);
	}
}
