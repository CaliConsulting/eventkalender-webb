package cali.eventkalender.facade;

import javax.ejb.Local;

import cali.eventkalender.model.Event;
import cali.eventkalender.model.Nation;

@Local
public interface FacadeLocal {

	Event addEvent(Event event);
	
	Nation addNation(Nation nation);
	
	void deleteEvent(long id);
	
	void deleteNation(long id);
	
	Event findEventById(long id);
	
	Nation findNationById(long id);
	
	Event updateEvent(Event event);
	
	Nation updateNation(Nation nation);
	
}
