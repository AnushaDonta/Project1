package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Observation;

public interface ObservationDao {
	Observation saveObservation(int eid,Observation observation);
	Observation getObservationById(int oid);
	boolean deleteObservationById(int oid);
	Observation updateObservationById(int oid,Observation observation);
	List<Observation> getAllObservations();
	List<Observation> getObservationsByDoctorName(String dname);
}
