package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Encounter;

public interface EncounterDao {
	Encounter saveEncounter(int bid,Encounter encounter);
	Encounter getEncounterById(int eid);
	boolean deleteEncounterById(int eid);
	Encounter updateEncounterById(int eid,Encounter encounter);
	List<Encounter> getAllEncounters();
}
