package cali.eventkalender.eao;

import java.util.List;

import javax.ejb.Local;

import cali.eventkalender.model.Person;

@Local
public interface PersonEAOLocal {

	Person add(Person person);
	
	void delete(long id);
	
	List<Person> findAll();
	
	Person findById(long id);
	
	Person update(Person person);
	
}
