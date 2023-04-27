package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.EncounterDaoImp;
import com.ty.hospital_app.dto.Encounter;

public class EncounterService {
	public void saveEncounter(Encounter encounter,int bid) {
		EncounterDaoImp edi=new EncounterDaoImp();
		Encounter encounter1=edi.saveEncounter(bid, encounter);
		if(encounter1!=null) {
			System.out.println("data saved");
		}
		else {
			System.out.println("unfortunately data not saved");
		}
	}
	
	public Encounter getEncounter(int eid) {
		EncounterDaoImp edi=new EncounterDaoImp();
		Encounter encounter=edi.getEncounterById(eid);
		if(encounter!=null) {
			return encounter;
		}
		else {
			return null;
		}
	}
	
	public void deleteEncounter(int eid) {
		EncounterDaoImp edi=new EncounterDaoImp();
		boolean flag=edi.deleteEncounterById(eid);
		if(flag==true) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not found");
		}
	}
	
	public Encounter updateEncounterById(int eid,Encounter encounter) {
		EncounterDaoImp edi=new EncounterDaoImp();
		Encounter encounter1=edi.updateEncounterById(eid, encounter);
		if(encounter1!=null) {
			return encounter1;
		}
		else {
			return null;
		}
	}
	public List<Encounter> getAllEncounters(){
		EncounterDaoImp edi=new EncounterDaoImp();
		List<Encounter> encounters=edi.getAllEncounters();
		return encounters;
	}
}