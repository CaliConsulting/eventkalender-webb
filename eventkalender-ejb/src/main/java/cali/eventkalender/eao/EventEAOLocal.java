package cali.eventkalender.eao;

import javax.ejb.Local;

import cali.eventkalender.model.Event;

@Local
public interface EventEAOLocal {

	Event add(Event event);
	
	void delete(long id);
	
	Event findById(long id);
	
	Event update(Event event);
	
}
