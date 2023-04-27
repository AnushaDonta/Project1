package com.ty.hospital_app.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	private String reason;
	private String DOJ;
	private String DOD;
	@OneToMany(mappedBy = "encounters")
	private List<Observation> observations;
	@JoinColumn
	@ManyToOne
	private Person persons;
	@JoinColumn
	@ManyToOne
	private Branch branches;
	@OneToMany(mappedBy = "encounters")
	private List<MedOrder> medOrders;
	
	public List<Observation> getObservations() {
		return observations;
	}
	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}
	public List<MedOrder> getMedOrders() {
		return medOrders;
	}
	public void setMedOrders(List<MedOrder> medOrders) {
		this.medOrders = medOrders;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public String getDOD() {
		return DOD;
	}
	public void setDOD(String dOD) {
		DOD = dOD;
	}
	public Person getPersons() {
		return persons;
	}
	public void setPersons(Person persons) {
		this.persons = persons;
	}
	public Branch getBranches() {
		return branches;
	}
	public void setBranches(Branch branches) {
		this.branches = branches;
	}
	
}
