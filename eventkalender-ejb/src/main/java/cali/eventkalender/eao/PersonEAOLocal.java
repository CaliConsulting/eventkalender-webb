package cali.eventkalender.eao;

import javax.ejb.Local;

import cali.eventkalender.model.Person;

@Local
public interface PersonEAOLocal {

	Person add(Person person);
	
	void delete(long id);
	
	Person findById(long id);
	
	Person update(Person person);
	
}
