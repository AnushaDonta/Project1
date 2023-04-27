package com.ty.hospital_app.dao;

import com.ty.hospital_app.dto.Hospital;

public interface HospitalDao {
	Hospital saveHospital(Hospital hospital);
	Hospital getHospitalById(int hid);
	boolean deleteHospitalById(int hid);
	Hospital updateHospitalById(int hid,Hospital hospital);
}
