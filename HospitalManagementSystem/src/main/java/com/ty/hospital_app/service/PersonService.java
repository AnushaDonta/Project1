package com.ty.hospital_app.service;

import java.util.List;

import com.ty.hospital_app.dao.imp.PersonDaoImp;
import com.ty.hospital_app.dto.Person;

public class PersonService {
	public void savePerson(Person person,int eid) {
		PersonDaoImp pdi=new PersonDaoImp();
		Person person1=pdi.savePerson(eid, person);
		if(person1!=null) {
			System.out.println("data saved");
		}
		else {
			System.out.println("unfortunately data not saved");
		}
	}
	
	public Person getPerson(int pid) {
		PersonDaoImp pdi=new PersonDaoImp();
		Person person=pdi.getPersonById(pid);
		if(person!=null) {
			return person;
		}
		else {
			return null;
		}
	}
	
	public void deletePerson(int pid) {
		PersonDaoImp pdi=new PersonDaoImp();
		boolean flag=pdi.deletePersonById(pid);
		if(flag==true) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not found");
		}
	}
	
	public Person updatePersonById(int pid,Person person) {
		PersonDaoImp pdi=new PersonDaoImp();
		Person person1=pdi.updatePersonById(pid, person);
		if(person1!=null) {
			return person1;
		}
		else {
			return null;
		}
	}
	
	public List<Person> getAllPersons(){
		PersonDaoImp pdi=new PersonDaoImp();
		List<Person> persons=pdi.getAllPersons();
		return persons;
	}
	
	public List<Person> getPersonsByGender(String gender){
		PersonDaoImp pdi=new PersonDaoImp();
		List<Person> persons=pdi.getPersonsByGender(gender);
		return persons;
	}
	
	public List<Person> getPersonsByAge(int age){
		PersonDaoImp pdi=new PersonDaoImp();
		List<Person> persons=pdi.getPersonsByAge(age);
		return persons;
	}
	
	public List<Person> getPersonsByPhono(long phono){
		PersonDaoImp pdi=new PersonDaoImp();
		List<Person> persons=pdi.getPersonsByPhono(phono);
		return persons;
	}
}
