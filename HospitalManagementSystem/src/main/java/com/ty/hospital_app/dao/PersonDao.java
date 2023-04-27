package com.ty.hospital_app.dao;

import java.util.List;

import com.ty.hospital_app.dto.Person;

public interface PersonDao {
	Person savePerson(int eid,Person person);
	Person getPersonById(int pid);
	boolean deletePersonById(int pid);
	Person updatePersonById(int pid,Person person);
	List<Person> getAllPersons();
	List<Person> getPersonsByGender(String gender);
	List<Person> getPersonsByAge(int age);
	List<Person> getPersonsByPhono(long phono);
}
