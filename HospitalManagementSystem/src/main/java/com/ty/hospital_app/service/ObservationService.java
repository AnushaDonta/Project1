package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.ObservationDaoImp;
import com.ty.hospital_app.dto.Observation;

public class ObservationService {
	public void saveObservation(Observation observation,int eid) {
		ObservationDaoImp odi=new ObservationDaoImp();
		Observation observation1=odi.saveObservation(eid,observation);
		if(observation1!=null) {
			System.out.println("data saved");
		}
		else {
			System.out.println("unfortunately data not saved");
		}
	}
	
	public Observation getObservation(int oid) {
		ObservationDaoImp odi=new ObservationDaoImp();
		Observation observation=odi.getObservationById(oid);
		if(observation!=null) {
			return observation;
		}
		else {
			return null;
		}
	}
	
	public void deleteObservation(int oid) {
		ObservationDaoImp odi=new ObservationDaoImp();
		boolean flag=odi.deleteObservationById(oid);
		if(flag==true) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not found");
		}
	}
	
	public Observation updateObservationById(int oid,Observation observation) {
		ObservationDaoImp odi=new ObservationDaoImp();
		Observation observation1=odi.updateObservationById(oid, observation);
		if(observation1!=null) {
			return observation1;
		}
		else {
			return null;
		}
	}
	
	public List<Observation> getAllObservations(){
		ObservationDaoImp odi=new ObservationDaoImp();
		List<Observation> observations=odi.getAllObservations();
		return observations;
	}
	
	public List<Observation> getObservationsByDoctorName(String dname){
		ObservationDaoImp odi=new ObservationDaoImp();
		List<Observation> observations=odi.getObservationsByDoctorName(dname);
		return observations;
	}
}
