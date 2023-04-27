package com.ty.hospital_app.controll;

import com.ty.hospital_app.dto.Hospital;
import com.ty.hospital_app.service.HospitalService;

public class TestSaveHospital {

	public static void main(String[] args) {
		Hospital hospital=new Hospital();
		hospital.setName("suguna");
		hospital.setWebsite("www.suguna.com");
		HospitalService service=new HospitalService();
		service.saveHospital(hospital);
	}

}
