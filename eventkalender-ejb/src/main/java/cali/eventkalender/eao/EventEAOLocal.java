package cali.eventkalender.eao;

import java.util.List;

import javax.ejb.Local;

import cali.eventkalender.model.Event;

@Local
public interface EventEAOLocal {

	Event add(Event event);
	
	void delete(long id);
	
	List<Event> findAll();
	
	Event findById(long id);
	
	Event update(Event event);
	
}
